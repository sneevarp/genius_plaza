package com.project.android.genius_plaza;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainApplication extends Application {
    public static ApiManager apiManager;
    @Override
    public void onCreate() {
        super.onCreate();
        apiManager = ApiManager.getInstance();
    }
}
