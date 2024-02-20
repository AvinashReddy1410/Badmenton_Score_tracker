package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R.id;

public class game_activity extends Activity {

    Button AT1, AT2, AT3, AT4;
    TextView TV2, TV3;

    private String team1Player1, team1Player2;
    private String team2Player1, team2Player2;

    private String RG;

    private boolean isTeam1Serving = true;
    private boolean isFirstServeOfTeam1 = true; // Track first serve of Team 1

    //Added By MSS
    boolean t1 = false,t2 = false;
    int flag_t1_t2 = 1;
    int curr_flag_t1_t2 = 1;
    int team;
    private int team1Score = 0;
    private int team2Score = 0;

    private int  currentScore, opponentScore;
    private boolean isServing;

    private static final int MAX_SCORE = 21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        // Retrieve team information from Intent
       // team1Name = getIntent().getStringExtra("team1Name");
        team1Player1 = getIntent().getStringExtra("team1Player1");
        team1Player2 = getIntent().getStringExtra("team1Player2");

       // team2Name = getIntent().getStringExtra("team2Name");
        team2Player1 = getIntent().getStringExtra("team2Player1");
        team2Player2 = getIntent().getStringExtra("team2Player2");

        //Getting serve team
        RG = getIntent().getStringExtra("serve");

        // Initialize UI elements
        AT1 = findViewById(id.AT1);
        AT2 = findViewById(id.AT2);
        AT3 = findViewById(id.AT3);
        AT4 = findViewById(id.AT4);

        TV2 = findViewById(id.TV2);
        TV3 = findViewById(id.TV3);

        // Set player names to buttons
        AT1.setText(team1Player1);
        AT2.setText(team1Player2);
        AT3.setText(team2Player1);
        AT4.setText(team2Player2);

        TV2.setText(String.valueOf(team1Score));
        TV3.setText(String.valueOf(team2Score));

        Toast.makeText(getApplicationContext(),"RG: "+RG, Toast.LENGTH_SHORT).show();
        if(RG.equals("TeamA")){
            t1 = true;
            isFirstServeOfTeam1 = true;
        }else if (RG.equals("TeamB")){
            t2 = true;
            isFirstServeOfTeam1 = false;
        }

        updateUI();

        AT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scorePointForTeam(1);
            }
        });

        AT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scorePointForTeam(1);
            }
        });

        AT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scorePointForTeam(2);
            }
        });

        AT4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scorePointForTeam(2);
            }
        });
    }

    private void scorePointForTeam(int teamNumber) {
        // Determine which team is scoring

        // Increment the team's score
        if (teamNumber == 1) {
            team1Score++;
            swapPlayers(teamNumber);
        } else if (teamNumber == 2) {
            team2Score++;
            swapPlayers(teamNumber);
        }

        // Check if the game is already won
        if(team1Score >= MAX_SCORE || team2Score >= MAX_SCORE){
            showSuccess("game Over");
        }

        // Update UI
        updateUI(); //Commented by MSS

    }

    private void swapPlayers(int team_no) {
        // Swap players for Team 1
        curr_flag_t1_t2= team_no;
        if(team_no == 1 && t1) {
            String temp = team1Player1;
            team1Player1 = team1Player2;
            team1Player2 = temp;
            curr_flag_t1_t2 = 1;
        }

        // Swap players for Team 2
        if(team_no == 2 && t2) {
            String temp = team2Player1;
            team2Player1 = team2Player2;
            team2Player2 = temp;
            curr_flag_t1_t2 = 2;
        }

        // Update player names on buttons
        if(flag_t1_t2 == 1 && curr_flag_t1_t2 == 1){
            t1 = true;
            t2 = false;
            isFirstServeOfTeam1= true;
        }
        if(flag_t1_t2 == 1 && curr_flag_t1_t2 == 2){
            curr_flag_t1_t2 = 2;
            flag_t1_t2 = 2;
            isFirstServeOfTeam1 = false;
        }
        if(flag_t1_t2 == 2 && curr_flag_t1_t2 == 1){
            curr_flag_t1_t2 = 1;
            flag_t1_t2 = 1;
            isFirstServeOfTeam1 = true;
        }
        if(flag_t1_t2 == 2 && curr_flag_t1_t2 == 2){
            t1 = false;
            t2 = true;
            isFirstServeOfTeam1 = false;
        }
        AT1.setText(team1Player1);
        AT2.setText(team1Player2);
        AT3.setText(team2Player1);
        AT4.setText(team2Player2);
    }

    private void color_swap_1()
    {
        AT1.setBackgroundColor(getColor(R.color.green));
        AT2.setBackgroundColor(getColor(android.R.color.transparent));
        AT3.setBackgroundColor(getColor(android.R.color.transparent));
        AT4.setBackgroundColor(getColor(android.R.color.transparent));
    }
    private void color_swap_2()
    {
        AT1.setBackgroundColor(getColor(android.R.color.transparent));
        AT2.setBackgroundColor(getColor(R.color.green));
        AT3.setBackgroundColor(getColor(android.R.color.transparent));
        AT4.setBackgroundColor(getColor(android.R.color.transparent));
    }
    private void color_swap_3()
    {
        AT1.setBackgroundColor(getColor(android.R.color.transparent));
        AT2.setBackgroundColor(getColor(android.R.color.transparent));
        AT3.setBackgroundColor(getColor(R.color.green));
        AT4.setBackgroundColor(getColor(android.R.color.transparent));
    }
    private void color_swap_4()
    {
        AT1.setBackgroundColor(getColor(android.R.color.transparent));
        AT2.setBackgroundColor(getColor(android.R.color.transparent));
        AT3.setBackgroundColor(getColor(android.R.color.transparent));
        AT4.setBackgroundColor(getColor(R.color.green));
    }
    private void updateUI() {
        // Update the UI based on the game state
        TV2.setText(String.valueOf(team1Score));
        TV3.setText(String.valueOf(team2Score));

        if (isFirstServeOfTeam1) {
            if (team1Score % 2 == 0) {
                color_swap_2();
            } else {
                color_swap_1();
            }
        } else {
            if (team2Score % 2 == 0) {
                color_swap_4();
            } else {
                color_swap_3();
            }
        }
    }

    private void showError(String message) {
        // Handle error messages here
        // For example, display a Toast message
        Toast.makeText(this, "Error: " + message, Toast.LENGTH_SHORT).show();
    }

    private void showSuccess(String message) {
        // Handle success messages here
        // For example, display a Toast message
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void resetGame() {
        // Reset the game state here if needed
        // For example, reset scores and player names
        team1Score = 0;
        team2Score = 0;
        updateUI(); // Update UI after resetting the game
    }
}
