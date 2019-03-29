package com.project.android.genius_plaza;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    String BASE_URL = "https://reqres.in/api/";

    @GET("users?page=1&per_page=12")
    Call<JSONResponse/*List<Users>*/> getMyJson();

    @POST("/users")
    Call<NewUser> createUser(@Body NewUser user);
}
