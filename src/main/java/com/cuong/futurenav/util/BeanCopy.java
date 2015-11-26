package com.cuong.futurenav.util;

import java.util.ArrayList;

import com.cuong.futurenav.controller.model.FavSchoolResponse;
import com.cuong.futurenav.controller.model.SchoolPropResponse;
import com.cuong.futurenav.controller.model.SchoolResponse;
import com.cuong.futurenav.controller.model.StudentProfileResponse;
import com.cuong.futurenav.dao.dto.FavSchoolEntity;
import com.cuong.futurenav.dao.dto.SchoolEntity;
import com.cuong.futurenav.dao.dto.SchoolPropertiesEntity;
import com.cuong.futurenav.dao.dto.StudentEntity;
import com.cuong.futurenav.model.FavSchoolData;
import com.cuong.futurenav.model.SchoolData;
import com.cuong.futurenav.model.SchoolPropertiesData;
import com.cuong.futurenav.model.StudentProfileData;

public class BeanCopy {

	public static void copyProperties(StudentProfileData source, StudentProfileResponse target) {

		org.springframework.beans.BeanUtils.copyProperties(source, target);

		ArrayList<FavSchoolResponse> favSchoolResponse = new ArrayList<FavSchoolResponse>();
		for (FavSchoolData data : source.getListOfFavSchool()) {
			FavSchoolResponse res = new FavSchoolResponse();
			org.springframework.beans.BeanUtils.copyProperties(data, res);
			SchoolResponse schoolRes = new SchoolResponse();
			copyProperties(data.getSchool(), schoolRes);
			res.setSchool(schoolRes);
			favSchoolResponse.add(res);

		}

		target.setListOfFavSchool(favSchoolResponse);

	}

	public static void copyProperties(StudentEntity source, StudentProfileData target) {

		org.springframework.beans.BeanUtils.copyProperties(source, target);

		ArrayList<FavSchoolData> schoolData = new ArrayList<FavSchoolData>();
		for (FavSchoolEntity entity : source.getListOfFavSchool()) {

			// copy schoolEntity to data
			SchoolData data = new SchoolData();
			copyProperties(entity.getSchool(), data);

			// copy favSchoolEntity to data
			FavSchoolData favData = new FavSchoolData();
			org.springframework.beans.BeanUtils.copyProperties(entity, favData);

			favData.setSchool(data);
			schoolData.add(favData);

		}

		target.setListOfFavSchool(schoolData);

	}

	public static void copyProperties(SchoolEntity source, SchoolData target){
		
		org.springframework.beans.BeanUtils.copyProperties(source, target);
		ArrayList<SchoolPropertiesData> details = new ArrayList<SchoolPropertiesData>();
		for (SchoolPropertiesEntity entity : source.getListOfSchoolProperties()){
			SchoolPropertiesData data = new SchoolPropertiesData();
			org.springframework.beans.BeanUtils.copyProperties(entity, data);
			details.add(data);
		}
		target.setListOfSchoolProperties(details);
		
	}
	
	public static void copyProperties(SchoolData source, SchoolResponse target){
		
		org.springframework.beans.BeanUtils.copyProperties(source, target);
		ArrayList<SchoolPropResponse> details = new ArrayList<SchoolPropResponse>();
		for (SchoolPropertiesData data : source.getListOfSchoolProperties()){
			SchoolPropResponse response = new SchoolPropResponse();
			org.springframework.beans.BeanUtils.copyProperties(data, response);
			details.add(response);
		}
		target.setListOfSchoolProperties(details);
		
	}
	
}
