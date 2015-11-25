package com.cuong.futurenav.business.wiki;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Cuong on 11/17/2015.
 */
public class RestClient {

    private static RestAdapter.Builder builder = new RestAdapter.Builder()
            .setLogLevel(RestAdapter.LogLevel.BASIC);

    static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").create();
    private static WikiApiService wikiService;
    private static DBPediaApiService pediaApiService;
    private static GoogleMapApiService googleApiService;

    public static WikiApiService getWikiApiService() {

        if (wikiService == null) {
            builder.setEndpoint(WikiApiService.BASE_URL);
            builder.setConverter(new GsonConverter(gson));
            RestAdapter restAdapter = builder.build();
            wikiService = restAdapter.create(WikiApiService.class);
        }

        return wikiService;
    }

    public static DBPediaApiService getPediaApiService() {

        if (pediaApiService == null) {
            builder.setEndpoint(DBPediaApiService.BASE_URL);
            builder.setConverter(new GsonConverter(gson));
            RestAdapter restAdapter = builder.build();
            pediaApiService = restAdapter.create(DBPediaApiService.class);
        }

        return pediaApiService;
    }

    public static GoogleMapApiService getGoogleApiService() {

        if (googleApiService == null) {
            builder.setEndpoint(GoogleMapApiService.BASE_URL);
            builder.setConverter(new GsonConverter(gson));
            RestAdapter restAdapter = builder.build();
            googleApiService = restAdapter.create(GoogleMapApiService.class);
        }

        return googleApiService;
    }    
    
}