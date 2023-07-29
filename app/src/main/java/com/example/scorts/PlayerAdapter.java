package com.example.scorts;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PlayerAdapter extends ArrayAdapter<Player> {

    int xml;
    List<Player> players;
    Context activityContext;
    boolean recruiting = false;

    public PlayerAdapter(@NonNull Context context, int resource, @NonNull List<Player> objects) {
        super(context, resource, objects);
        xml = resource;
        players = objects;
        activityContext = context;
    }

    public void setRecruiting(boolean r)
    {
        recruiting = r;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View myCustomView;
        LayoutInflater layoutInflater = (LayoutInflater)activityContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        myCustomView = layoutInflater.inflate(xml, null);

        TextView name = myCustomView.findViewById(R.id.player_name);
        TextView team = myCustomView.findViewById(R.id.player_team);
        TextView runs = myCustomView.findViewById(R.id.player_runs);
        TextView wickets = myCustomView.findViewById(R.id.player_wickets);

        name.setText(players.get(position).getName());
        team.setText(players.get(position).getTeam());
        runs.setText(players.get(position).getRuns());
        wickets.setText(players.get(position).getWickets());

        if(recruiting)
        {
            myCustomView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //add player to team
                    //return to Team Activity
                }
            });
        }

        return myCustomView;
    }

}
