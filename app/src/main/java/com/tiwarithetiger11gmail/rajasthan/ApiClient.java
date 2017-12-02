package com.tiwarithetiger11gmail.rajasthan;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MURARI TIWARI on 11/28/2017.
 */

public class ApiClient {

    private static  final String BASE_URL="http://10.0.2.2:3000";
    public static Retrofit retrofit=null;

    public static  Retrofit getApiClient() {
        if(retrofit==null){

            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
