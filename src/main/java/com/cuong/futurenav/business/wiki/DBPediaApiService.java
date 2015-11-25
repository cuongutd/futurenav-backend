package com.cuong.futurenav.business.wiki;

import java.util.ArrayList;
import java.util.HashMap;

import com.cuong.futurenav.model.wiki.DBPage;
import com.cuong.futurenav.model.wiki.DBValue;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface DBPediaApiService {
    
	public static final String BASE_URL = "http://dbpedia.org";
    
    @GET("/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&format=application%2Fsparql-results%2Bjson")
    public DBPage getSchoolInfoFromDBPedia(@Query("query") String query);

    @GET("/data/{schoolName}.json")
    public HashMap<String, HashMap<String, ArrayList<DBValue>>> getSchoolInfoFromDBPedia2(@Path(value="schoolName", encode=false) String schoolName);

}
