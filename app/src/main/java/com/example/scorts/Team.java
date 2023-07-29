package com.example.scorts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;

public class Team extends AppCompatActivity {

    // ... (previous code remains the same)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Make the activity full-screen
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_team);

        // Create a fake array of team data
        ArrayList<TeamView> team = new ArrayList<>();

        team.add(new TeamView("Vignesh", 100, 100, "India"));
        team.add(new TeamView("Sachin", 100, 0, "India"));


        // Create an adapter
        TeamViewAdapter adapter = new TeamViewAdapter(this, 0, team);

        // Set the adapter to the list view
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

}