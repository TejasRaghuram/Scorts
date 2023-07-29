package com.example.scorts;

public class TeamView {

    private final String name;
    private final int runs;
    private final int wickets;
    private final String team;

    public TeamView(String name, int runs, int wickets, String team) {
        this.name = name;
        this.runs = runs;
        this.wickets = wickets;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public int getRuns() {
        return runs;
    }

    public int getWickets() {
        return wickets;
    }

    public String getTeam() {
        return team;
    }


}
