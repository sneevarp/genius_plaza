package com.project.android.genius_plaza;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Create extends AppCompatActivity {

    EditText fname,fjob;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        initView();
    }
    public void initView(){
        fname=findViewById(R.id.name);
        fjob=findViewById(R.id.job);
    }

    public void createButton(View view) {
        NewUser user = new NewUser(fname.getText().toString(),fjob.getText().toString());
        //progressBar.setVisibility(View.VISIBLE);
        MainApplication.apiManager.createUser(user, new Callback<NewUser>() {
            @Override
            public void onResponse(Call<NewUser> call, Response<NewUser> response) {
                //progressBar.setVisibility(View.GONE);
                NewUser responseUser = response.body();
                if (response.isSuccessful() && responseUser != null) {
                    Toast.makeText(Create.this,
                            String.format("User %s with job %s was created at %s with id %s",
                                    responseUser.getName(),
                                    responseUser.getJob(),
                                    responseUser.getCreatedAt(),
                                    responseUser.getId()),
                            Toast.LENGTH_LONG)
                            .show();
                } else {
                    Toast.makeText(Create.this,
                            String.format("Response is %s", String.valueOf(response.code()))
                            , Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<NewUser> call, Throwable t) {
                //progressBar.setVisibility(View.GONE);
                Toast.makeText(Create.this,
                        "Error is " + t.getMessage()
                        , Toast.LENGTH_LONG).show();
            }
        });

    }
}
