package com.example.gbrot.tabletennisscoreboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Playername extends AppCompatActivity {
EditText Player1, Player2, Player11, Player22;
Button startgame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playername);

        Player1 = (EditText) findViewById(R.id.player1);
        Player2 = (EditText) findViewById(R.id.player2);
        Player11 = (EditText) findViewById(R.id.player11);
        Player22 = (EditText) findViewById(R.id.player22);
        startgame = (Button) findViewById(R.id.button);



        startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String textToPass = Player1.getText().toString();
                String textToPass1 = Player2.getText().toString();
                String textToPass2 = Player11.getText().toString();
                String textToPass3 = Player22.getText().toString();


                if(textToPass.equals("")){
                    Player1.setError("Required field ");
                   // return;
                }
                else if(textToPass1.equals("")){
                    Player2.setError("Required field ");
                }
                else if(textToPass2.equals("")){
                    Player11.setError("Required field ");
                }
                else if(textToPass3.equals("")){
                    Player22.setError("Required field ");
                }

                else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("player1 name", textToPass);
                    intent.putExtra("player2 name", textToPass1);
                    intent.putExtra("player11 name", textToPass2);
                    intent.putExtra("player22 name", textToPass3);
                    startActivity(intent);
                }
            }
        });



    }

    public void empty(){
//        String strUser = Player1.getText().toString();
//        String strUser1 = Player2.getText().toString();
//        String strUser2 = Player11.getText().toString();
//        String strUser3 = Player22.getText().toString();


    }
}
