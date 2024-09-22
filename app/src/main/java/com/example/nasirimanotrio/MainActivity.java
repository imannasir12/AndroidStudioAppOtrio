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

public class MainActivity extends AppCompatActivity {
    //button for sound
    Button instruct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //finds button
        instruct = (Button) findViewById(R.id.instruct);

        //plays sound when button is clicked
        instruct.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.click);
                mp.start();
                return false;
            }
        });
    }

    //takes user to instructions screen
    public void toInstructions(View view) {
        Intent i = new Intent(this, Instructions.class);
        startActivity(i);
    }
}