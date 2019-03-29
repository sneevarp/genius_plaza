package com.project.android.genius_plaza;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.support.constraint.Constraints.TAG;

public class UsersViewModel extends ViewModel {
    private MutableLiveData<List<Users>> UsersList;

    //we will call this method to get the data
    public LiveData<List<Users>> getUsers() {
        //if the list is null
        if (UsersList == null) {
            UsersList = new MutableLiveData<List<Users>>();
            //we will load it asynchronously from server in this method
            loadUsers();
        }

        //finally we will return the list
        return UsersList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadUsers() {
        Log.d("praveen", "loadUsers Started ");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<JSONResponse> call = api.getMyJson();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                Log.d("praveen", response.body().getUsers().toString());

                UsersList.setValue(response.body().getUsers());
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("praveen", "api failure ");
            }
        });
    }
}
