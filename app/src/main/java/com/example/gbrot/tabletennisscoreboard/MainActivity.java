package com.example.gbrot.tabletennisscoreboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    // Tracks the score for Team A
    int scoreTeamA = 0;
    // Tracks the score for Team B
    int scoreTeamB = 0;

    int reset=0;

    TextView Team1,Team2 ,scoreView, scoreView1;
    EditText NOP,NOS;
    int finalValue,  finalValue1,finalValue3,finalValue4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Team1 = (TextView) findViewById(R.id.team1name);
        Team2 = (TextView) findViewById(R.id.team2name);






        String plr1 = getIntent().getStringExtra("player1 name");
        String plr2 = getIntent().getStringExtra("player2 name");
        String plr11 = getIntent().getStringExtra("player11 name");
        String plr22 = getIntent().getStringExtra("player22 name");

        String[] separated = plr1.split(" ");
        String[] separated1 = plr2.split(" ");
        String[] separated2 = plr11.split(" ");
        String[] separated3 = plr22.split(" ");

Team1.setText(separated[0]+"/"+separated1[0]);
        Team2.setText(separated2[0]+"/"+separated3[0]);




    }






public void noofsets(){
    String strUserName = NOS.getText().toString();

    if(strUserName.equals("0")) {
       NOS.setError("enter no. of sets ");
        return;
    }
}

    public void noofpoints(){
        String strUserName1 = NOP.getText().toString();

        if(strUserName1.equals("0")) {
            NOP.setError("enter no. of points ");
            return;
        }
    }
    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOne(View v) {

        NOS = (EditText) findViewById(R.id.nos);
        String value1= NOS.getText().toString();
        finalValue1=Integer.parseInt(value1);


        NOP = (EditText) findViewById(R.id.nop);
        scoreView = (TextView) findViewById(R.id.team_a_score);

        String value= NOP.getText().toString();
        finalValue=Integer.parseInt(value);

        String value3= scoreView.getText().toString();
        finalValue3=Integer.parseInt(value3);

        if (finalValue == 0) {
            noofpoints();
            noofsets();
        } else {
            if (finalValue <= finalValue3) {
                scoreTeamA=0;
                scoreTeamB=0;
                displayForTeamA(scoreTeamA);
                displayForTeamB(scoreTeamB);
                Toast.makeText(getApplicationContext(), "Team 1 won", Toast.LENGTH_LONG).show();
            } else {
                scoreTeamA += 1;
                displayForTeamA(scoreTeamA);

            }
        }
    }
    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneTeamB(View v) {
        NOS = (EditText) findViewById(R.id.nos);
        String value1= NOS.getText().toString();
        finalValue1=Integer.parseInt(value1);


        NOP = (EditText) findViewById(R.id.nop);
        scoreView1 = (TextView) findViewById(R.id.team_b_score);

        String value= NOP.getText().toString();
        finalValue=Integer.parseInt(value);
        String value4= scoreView1.getText().toString();
        finalValue4=Integer.parseInt(value4);

        if(finalValue==0){
            noofsets();
            noofpoints();
        }
        else if(finalValue<=finalValue4){
            Toast.makeText(getApplicationContext(),"Team 2 won",Toast.LENGTH_LONG).show();
            scoreTeamA=0;
            scoreTeamB=0;
            displayForTeamA(scoreTeamA);
            displayForTeamB(scoreTeamB);
        }
        else {
            scoreTeamB += 1;
            displayForTeamB(scoreTeamB);
        }
    }



public void leaderboard(View v){
    Intent i = new Intent(MainActivity.this,Leaderboard.class);
    startActivity(i);
}


    /**
     * Decrease the score for Team A by 1 point.
     */
    public void subOne(View v) {
        if(  scoreTeamA > 0)
        {
            scoreTeamA -= 1;
            displayForTeamA(scoreTeamA);
        }
        else
        {
            displayForTeamA(scoreTeamA);
            Toast.makeText(getApplicationContext(),"No negative points",Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Decrease the score for Team A by 1 point.
     */
    public void subOneTeamB(View v) {
        if(scoreTeamB > 0)
        {
            scoreTeamB -= 1;
            displayForTeamB(scoreTeamB);
        }
        else
        {
            displayForTeamB(scoreTeamB);
            Toast.makeText(getApplicationContext(),"No negative points",Toast.LENGTH_LONG).show();
        }

    }
    /**
     * Resets the score for team A back to 0 and the fouls.
     */
    public void resetScoreA(View v) {
        scoreTeamA = 0;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Resets the score for team B back to 0 and the fouls.
     */
    public void resetScoreB(View v) {
        scoreTeamB = 0;
        displayForTeamB(scoreTeamB);
    }



    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        scoreView1 = (TextView) findViewById(R.id.team_b_score);
        scoreView1.setText(String.valueOf(score));
    }

}
