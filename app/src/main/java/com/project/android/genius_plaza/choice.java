package com.project.android.genius_plaza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class choice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
    }

    public void getButton(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }

    public void postButton(View view) {
        startActivity(new Intent(this, Create.class));
    }
}
