package com.example.scorts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;

public class Recruit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Make the activity full-screen
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_recruit);


        // Create a fake array of team data
        ArrayList<TeamView> team = new ArrayList<>();
        team.add(new TeamView("Sachin", 100, 0, "India"));
        team.add(new TeamView("Virat", -50, 0, "India"));
        team.add(new TeamView("Dhoni", 1000, 0, "India"));
        team.add(new TeamView("Rohit", 100, 0, "India"));
        team.add(new TeamView("Rahul", 100, 0, "India"));

        // Create an adapter
        TeamViewAdapter adapter = new TeamViewAdapter(this, 0, team);

        // Set the adapter to the list view
        ListView listView = findViewById(R.id.list_view_second);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(Recruit.this, Team.class);
            startActivity(intent);
        });

    }
}