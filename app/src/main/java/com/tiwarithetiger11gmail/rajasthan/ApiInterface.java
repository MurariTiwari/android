package com.tiwarithetiger11gmail.rajasthan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by MURARI TIWARI on 11/28/2017.
 */

public interface ApiInterface {

    @GET("/android")
     Call<List<Modal>> getModal();

}
