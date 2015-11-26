package com.cuong.futurenav.business.wiki;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuong.futurenav.dao.SchoolJpaRepository;
import com.cuong.futurenav.dao.SchoolPropertiesJpaRepository;
import com.cuong.futurenav.dao.dto.SchoolEntity;
import com.cuong.futurenav.dao.dto.SchoolPropertiesEntity;
import com.cuong.futurenav.model.wiki.Category;
import com.cuong.futurenav.model.wiki.CategoryMember;
import com.cuong.futurenav.model.wiki.DBItem;
import com.cuong.futurenav.model.wiki.DBPage;
import com.cuong.futurenav.model.wiki.DBValue;
import com.cuong.futurenav.model.wiki.GMData;
import com.cuong.futurenav.model.wiki.img.Data;
import com.cuong.futurenav.model.wiki.img.Page;
import com.cuong.futurenav.util.Constants;
import com.cuong.futurenav.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WikiManager {

	@Autowired
	SchoolJpaRepository schoolRepo;

	@Autowired
	SchoolPropertiesJpaRepository schoolProRepo;

	private static final Logger LOG = LoggerFactory.getLogger(WikiManager.class);

	private static final String catUS = "Category:Private_high_schools_in_the_United_States_by_state";
	private static final String catUSRoman = "Category:Roman Catholic secondary schools in the United States by state".replace(" ", "_");


	public void getSchoolListFromWiki() {
		getSchoolListFromWiki(catUS);
		getSchoolListFromWiki(catUSRoman);

	}

	private void getSchoolListFromWiki(String category) {

		// first get subcats
		Category subCat = RestClient.getWikiApiService().getCategoryWiki("subcat", category);

		int i = 0;

		for (CategoryMember member : subCat.getQuery().getCategorymembers()) {

			String cat = member.getTitle().replace(" ", "_");

			// next get cat members, which are school name
			Category schoolNames = RestClient.getWikiApiService().getSchoolListStateFromWiki(cat);

			for (CategoryMember stateMember : schoolNames.getQuery().getCategorymembers()) {
				i++;
				// for each school name, go get school info from DBPedia and
				// insert into DB
				getSchoolInfo2(stateMember.getTitle().replace(" ", "_"));
			}
		}

		LOG.debug("Number of schools: " + i);
	}
	
	public void updateCrestUrl(){
		

		
		LOG.debug("Check the result plz!");		
		
		
		List<SchoolEntity> schools = schoolRepo.findFast();
		
		for (SchoolEntity school : schools){
			
			//get first image of the wiki shool page, hope its the crest we are looking for
			Data titleData = RestClient.getWikiApiService().getImageName(school.getName());
			
			HashMap<Integer, Page> pages = titleData.getQuery().getPages();
			String imageTitle = null;
			String url = null;
			try{
				for (Map.Entry<Integer, Page> page : pages.entrySet()){
					imageTitle = page.getValue().getImages().get(0).getTitle();
					break;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
			//next with the image title, get the wiki url of the image
			if (imageTitle != null){
				Data urlData = RestClient.getWikiApiService().getImageUrl(imageTitle);

				pages = urlData.getQuery().getPages();
				try{
					for (Map.Entry<Integer, Page> page : pages.entrySet()){
						url = page.getValue().getImageinfo().get(0).getUrl();
						break;
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			
				if (url != null){
					//create new school property
					SchoolPropertiesEntity prop = new SchoolPropertiesEntity();
					prop.setName("cresturl");
					prop.setValue(url);
					prop.setSchool(school);
					schoolProRepo.save(prop);
					
				}
				
			}			
		}
		
		
	}
	
	

	private void getSchoolInfo2(String schoolName) {
		try {
			HashMap<String, HashMap<String, ArrayList<DBValue>>> page = RestClient.getPediaApiService()
					.getSchoolInfoFromDBPedia2(schoolName);
			// insert school
			SchoolEntity school = parseWiki(page, schoolName);
			schoolRepo.save(school);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateLatLong() {
		// get a schools not having lat, long populated
		List<SchoolEntity> schools = schoolRepo.findByLatitudeIsNullOrLongitudeIsNull();
		List<SchoolEntity> updateList = new ArrayList<SchoolEntity>();
		LOG.debug("number of records: " + schools.size());
		int i = 0;
		for (SchoolEntity entity : schools) {
			entity.setListOfSchoolProperties(null);
			try {
				String query = entity.getName();
				if (entity.getCity() != null && entity.getCity().length() > 0)
					query += ", " + entity.getCity();
				if (entity.getState() != null && entity.getState().length() > 0)
					query += ", " + entity.getState();

				// try google map service with school name and state to get
				// lat/long
				GMData data = RestClient.getGoogleApiService().getGeo(query);
				if ("OVER_QUERY_LIMIT".equals(data.getStatus()))
					break;

				i++;

				entity.setLatitude(Double.valueOf(data.getResults().get(0).getGeometry().getLocation().getLat()));
				entity.setLongitude(Double.valueOf(data.getResults().get(0).getGeometry().getLocation().getLng()));

				updateList.add(entity);

			} catch (Exception e) {
				LOG.debug("Error: " + entity.getName() + ", " + entity.getState());
				e.printStackTrace();
			}
		}
		LOG.debug("number of records being updated: " + i);

		schoolRepo.save(updateList);
	}

	private void getSchoolInfo(String schoolName) {
		String query = null;
		StringBuilder builder = new StringBuilder();
		builder.append("PREFIX db: <http://dbpedia.org/resource/> ");
		builder.append("select ?property ?value ");
		builder.append("where { ");
		builder.append("db:" + schoolName + " ?property ?value. }");
		query = builder.toString();
		try {
			DBPage page = RestClient.getPediaApiService().getSchoolInfoFromDBPedia(query);
			// insert school
			SchoolEntity school = parseWiki(page);
			schoolRepo.save(school);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private SchoolEntity parseWiki(HashMap<String, HashMap<String, ArrayList<DBValue>>> page, String schoolName) {

		SchoolEntity school = new SchoolEntity();
		ArrayList<SchoolPropertiesEntity> props = new ArrayList<SchoolPropertiesEntity>();
		school.setListOfSchoolProperties(props);

		HashMap<String, ArrayList<DBValue>> result = page.get("http://dbpedia.org/resource/" + schoolName);

		for (Map.Entry<String, ArrayList<DBValue>> entry : result.entrySet()) {

			String property = entry.getKey();

			if (property != null) {

				String value = entry.getValue().get(0).getValue();
				value = value.replace("http://dbpedia.org/resource/", "");
				String type = entry.getValue().get(0).getType();
				if (property.equals(Constants.sPropertyName) || property.equals(Constants.sPropertyLabel))
					school.setName(value);
				else if (property.equals(Constants.sPropertyLat))
					school.setLatitude(Double.valueOf(value));
				else if (property.equals(Constants.sPropertyLong))
					school.setLongitude(Double.valueOf(value));
				else if (property.equals(Constants.sPropertyPageId))
					school.setWikipageid(value);
				else if (property.equals(Constants.sPropertyRevisionId))
					school.setWikirevisionid(value);
				else if (property.equals(Constants.sPropertyCity))
					school.setCity(value);
				else if (property.equals(Constants.sPropertyState))
					school.setState(value);
				else if (property.equals(Constants.sPropertyGrades))
					school.setGrades(value);
				else if (property.equals(Constants.sPropertyType))
					school.setType(value);
				else {
					// school prop
					SchoolPropertiesEntity entity = new SchoolPropertiesEntity();
					entity.setSchool(school);
					entity.setName(property);
					entity.setValue(value);
					school.getListOfSchoolProperties().add(entity);

				}
			}
		}

		return school;
	}

	private SchoolEntity parseWiki(DBPage page) {

		SchoolEntity school = new SchoolEntity();
		// ArrayList<SchoolPropertiesEntity> props = new
		// ArrayList<SchoolPropertiesEntity>();
		// school.setListOfSchoolProperties(props);
		//
		// for (DBItem item : page.getResults().getBindings()){
		//
		// String property =
		// WikiPropUtil.acceptProp(item.getProperty().getValue());
		//
		// if (property != null)
		//
		// if
		// (property.equals(WikiPropUtil.sPropertyName)||property.equals(WikiPropUtil.sPropertyLabel))
		// school.setName(item.getValue().getValue());
		// else if(property.equals(WikiPropUtil.sPropertyLat))
		// school.setLatitude(Double.valueOf(item.getValue().getValue()));
		// else if(property.equals(WikiPropUtil.sPropertyLong))
		// school.setLongitude(Double.valueOf(item.getValue().getValue()));
		// else if(property.equals(WikiPropUtil.sPropertyPageId))
		// school.setWikipageid(item.getValue().getValue());
		// else if(property.equals(WikiPropUtil.sPropertyRevisionId))
		// school.setWikirevisionid(item.getValue().getValue());
		// else if(property.equals(WikiPropUtil.sPropertyCity))
		// school.setCity(item.getValue().getValue());
		// else if(property.equals(WikiPropUtil.sPropertyState))
		// school.setState(item.getValue().getValue());
		// else if (property.equals(WikiPropUtil.sPropertyGrades))
		// school.setGrades(item.getValue().getValue());
		// else if (property.equals(WikiPropUtil.sPropertyType))
		// school.setType(item.getValue().getValue());
		// else{
		// //school prop
		//
		// SchoolPropertiesEntity entity = new SchoolPropertiesEntity();
		// entity.setSchool(school);
		// entity.setName(property);
		// entity.setValue(item.getValue().getValue());
		// school.getListOfSchoolProperties().add(entity);
		//
		// }
		// }

		return school;
	}

}
