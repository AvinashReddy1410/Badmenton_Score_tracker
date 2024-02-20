package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;
public class Team {
    private String teamName;
    private List<String> playerNames;

    public Team(String teamName, String player1Name, String player2Name) {
        this.teamName = teamName;
        this.playerNames = new ArrayList<>();
        playerNames.add(player1Name);
        playerNames.add(player2Name);
    }
    //// Getter method to retrieve the list of player names
    public List<String> getPlayerNames() {
        return playerNames;
    }
    // // Getter method to retrieve the team name
    public String getTeamName() {
        return teamName;
    }
}
