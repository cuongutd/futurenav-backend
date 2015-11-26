package com.cuong.futurenav.business.wiki;

import com.cuong.futurenav.model.wiki.Category;
import com.cuong.futurenav.model.wiki.img.Data;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Cuong on 8/25/2015.
 */
public interface WikiApiService {
    
	public static final String BASE_URL = "https://en.wikipedia.org";
    
    @GET("/w/api.php?action=query&list=categorymembers&cmtitle=Category:Private_high_schools_in_the_United_States_by_state&cmtype=subcat&cmlimit=100&format=json")
    public Category getSchoolListUSFromWiki();

    @GET("/w/api.php?action=query&list=categorymembers&cmlimit=500&format=json")
    public Category getCategoryWiki(@Query(value="cmtype") String type, @Query("cmtitle") String title);
    
    @GET("/w/api.php?action=query&prop=images&format=json&imlimit=1") 
    public Data getImageName(@Query("titles") String schoolName); 
    	
	@GET("/w/api.php?action=query&prop=imageinfo&iiprop=url&format=json")	
    public Data getImageUrl(@Query("titles") String imageName);	
    	
    @GET("/w/api.php?action=query&list=categorymembers&cmtype=page&cmlimit=500&format=json")
    public Category getSchoolListStateFromWiki(@Query("cmtitle") String subCat);

}
