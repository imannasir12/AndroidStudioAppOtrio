//Name:Iman Nasir
//Date: October 22,2021
//Purpose:TicTacToe project
package com.example.nasirimanotrio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class Instructions extends AppCompatActivity {
    //buttons for sound
    Button onePlayer;
    Button twoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        //finds buttons
        onePlayer = (Button) findViewById(R.id.onePlayer);
        twoPlayer = (Button) findViewById(R.id.twoPlayer);

        //plays sound when button is clicked
        onePlayer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                MediaPlayer mp = MediaPlayer.create(Instructions.this, R.raw.click);
                mp.start();
                return false;
            }
        });

        //plays sound when button is clicked
        twoPlayer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                MediaPlayer mp = MediaPlayer.create(Instructions.this, R.raw.click);
                mp.start();
                return false;
            }
        });
    }

    //takes user to one player game screen
    public void onePlayer(View view) {
        Intent i = new Intent(this, Game2.class);
        startActivity(i);
    }

    //takes user to two player game screen
    public void twoPlayer(View view) {
        Intent i = new Intent(this, Game.class);
        startActivity(i);
    }
}