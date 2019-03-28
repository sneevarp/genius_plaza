package com.project.android.genius_plaza;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    UsersAdapter adapter;
    List<Users> UsersList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Log.d("praveen", "main activity Started ");
        UsersViewModel model = ViewModelProviders.of(this).get(UsersViewModel.class);

        model.getUsers().observe(this, new Observer<List<Users>>() {
            @Override
            public void onChanged(@Nullable List<Users> UsersList) {
                Log.d("praveen", "main activity on change Started ");
                adapter = new UsersAdapter(MainActivity.this, UsersList);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
