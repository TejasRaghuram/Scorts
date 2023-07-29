package com.example.scorts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TeamViewAdapter extends ArrayAdapter<TeamView> {

    public TeamViewAdapter(@NonNull Context context, int resource, @NonNull ArrayList<TeamView> teamList) {
        super(context, resource, teamList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;

        if (listItem == null) {
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.player_layout, parent, false);
        }

        TeamView currentTeam = getItem(position);

        TextView name = listItem.findViewById(R.id.player_name);
        TextView runs = listItem.findViewById(R.id.player_runs);
        TextView wickets = listItem.findViewById(R.id.player_wickets);
        TextView team = listItem.findViewById(R.id.player_team);

        name.setText(currentTeam.getName());
        runs.setText(String.valueOf(currentTeam.getRuns()));
        wickets.setText(String.valueOf(currentTeam.getWickets()));
        team.setText(currentTeam.getTeam());

        return listItem;
    }
}
