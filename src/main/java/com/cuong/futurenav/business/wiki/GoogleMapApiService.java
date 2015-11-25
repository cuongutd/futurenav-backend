package com.cuong.futurenav.business.wiki;

import com.cuong.futurenav.model.wiki.GMData;

import retrofit.http.GET;
import retrofit.http.Query;

public interface GoogleMapApiService {
public static final String BASE_URL = "http://maps.google.com/maps";
    
    @GET("/api/geocode/json")
    public GMData getGeo(@Query("address") String address);
}
