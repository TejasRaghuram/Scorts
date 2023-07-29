package com.example.scorts;

public class Player {

    private String name;
    private String team;
    private int runs;
    private int wickets;

    public Player(String n, String t, int r, int w)
    {
        name = n;
        team = t;
        runs = r;
        wickets = w;
    }

    public void setTeam(String t)
    {
        team = t;
    }

    public String getName()
    {
        return name;
    }

    public String getTeam()
    {
        return team;
    }

    public int getRuns()
    {
        return runs;
    }

    public int getWickets()
    {
        return wickets;
    }

}
