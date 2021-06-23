package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startColorGame = findViewById(R.id.ColorGame_btn);
        startColorGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ColorGame.class);
                startActivity(intent);
            }
        });

        Button startNumberGame = findViewById(R.id.numbeGame_btn);
        startNumberGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NumbeGame.class);
                startActivity(intent);
            }
        });

        Button startMathGame = findViewById(R.id.mathGame_btn);
        startMathGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MathGame.class);
                startActivity(intent);
            }
        });

        Button startChallengeMode = findViewById(R.id.challengeMode_btn);
        startChallengeMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChallengeMode.class);
                startActivity(intent);
            }
        });


    }

    public void StartColorGame(){

    }
}