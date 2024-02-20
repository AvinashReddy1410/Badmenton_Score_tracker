package com.example.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button BSG;
    private EditText ETP1, ETP2, ETP3, ETP4;
    private RadioGroup RG;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        BSG = findViewById(R.id.BSG);
        ETP1 = findViewById(R.id.ETP1);
        ETP2 = findViewById(R.id.ETP2);
        ETP3 = findViewById(R.id.ETP3);
        ETP4 = findViewById(R.id.ETP4);
        RG = findViewById(R.id.RG);

        BSG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String P1, P2, P3, P4;
                P1 = ETP1.getText().toString();
                P2 = ETP2.getText().toString();
                P3 = ETP3.getText().toString();
                P4 = ETP4.getText().toString();

                // Check which radio button is selected
                int selectedRadioButtonId = RG.getCheckedRadioButtonId();

                if (selectedRadioButtonId == R.id.RB1) {
                    // RadioButton Team1 is selected
                    // Handle the logic for Team1
                    Team team1 = new Team("Team A", P1, P2);
                    Team team2 = new Team("Team B", P3, P4);
                    // Example: You can pass the teams to the next activity
                    Intent intent = new Intent(MainActivity.this, game_activity.class);
                    intent.putExtra("team1Name", team1.getTeamName());
                    intent.putExtra("team1Player1", team1.getPlayerNames().get(0));
                    intent.putExtra("team1Player2", team1.getPlayerNames().get(1));
                    intent.putExtra("team2Name", team2.getTeamName());
                    intent.putExtra("team2Player1", team2.getPlayerNames().get(0));
                    intent.putExtra("team2Player2", team2.getPlayerNames().get(1));
                    intent.putExtra("serve","TeamA");
                    startActivity(intent);
                } else if (selectedRadioButtonId == R.id.RB2) {
                    // RadioButton Team2 is selected
                    // Handle the logic for Team2
                    Team team1 = new Team("Team A", P1, P2);
                    Team team2 = new Team("Team B", P3, P4);
                    // Example: You can pass the teams to the next activity
                    Intent intent = new Intent(MainActivity.this, game_activity.class);
                    intent.putExtra("team1Name", team1.getTeamName());
                    intent.putExtra("team1Player1", team1.getPlayerNames().get(0));
                    intent.putExtra("team1Player2", team1.getPlayerNames().get(1));
                    intent.putExtra("team2Name", team2.getTeamName());
                    intent.putExtra("team2Player1", team2.getPlayerNames().get(0));
                    intent.putExtra("team2Player2", team2.getPlayerNames().get(1));
                    intent.putExtra("serve","TeamB");
                    startActivity(intent);
                } else {
                    // No RadioButton is selected, handle accordingly
                    Toast.makeText(MainActivity.this, "Please select a team", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
