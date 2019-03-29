package com.project.android.genius_plaza;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateViewModel extends ViewModel {
    private MutableLiveData<NewUser> User;

    //we will call this method to get the data
    public LiveData<NewUser> getUsers() {
        //if the list is null
        if (User == null) {
            User = new MutableLiveData<NewUser>();
            //we will load it asynchronously from server in this method
            postUser();
        }
        //finally we will return the list
        return User;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void postUser() {
    }
}
