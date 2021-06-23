package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MathGame extends AppCompatActivity {
    int q1, q1_2, q1_A, count, q2, q2_2;
    EditText q1Answer, q2Answer;
    TextView txtQ1, txtQ2;
    Button lvlOne_btn, lvlTwo_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game);
        txtQ1 = findViewById(R.id.qOne_tv);
        q1Answer = findViewById(R.id.enterAnswerOne);
        lvlOne_btn = findViewById(R.id.lvlOne_btn);
        lvlTwo_btn = findViewById(R.id.lvlTwo_btn);
        Button check = findViewById(R.id.check_btn);

        q1 = 1;
        q1_2 = 2;
        q2 = 0;
        q2_2 = 0;

        lvlOne_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                PopulateField();
            }
        });

        lvlTwo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                LevelTwo();
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswerOne();
            }
        });



    }

    public void CheckAnswerOne(){
        q1_A = Integer.parseInt(q1Answer.getText().toString());
        if(count == 0) {

            if (q1_A == q1 + q1_2) {
                q1Answer.setText("");
                Increment(q1_A, q1_2);
            } else {
                txtQ1.setText("Wrong Answer");
            }
        } else {
            if (q1_A == q2 + q2_2) {
                q1Answer.setText("");
                LevelTwo();
            } else {
                txtQ1.setText("Wrong Answer");
            }
        }
    }

    public void CheckAnswerTwo(){

    }

    public void Increment(int qA, int q_H){
        q1 = q_H;
        q1_2 = qA;
        txtQ1.setText(q1 + " + " + q1_2);
        q1Answer.setText("");

    }

    public void PopulateField(){
            txtQ1.setText(q1 + " + " + q1_2);
            //txtQ2.findViewById(R.id.qTwo_tv);
            //txtQ2.setText(q2 + " + " + q2_1);
    }
    public void PopulateField2(int q2, int q2_2){
        txtQ1.setText(q2 + " + " + q2_2);
        //txtQ2.findViewById(R.id.qTwo_tv);
        //txtQ2.setText(q2 + " + " + q2_1);
    }

    public void LevelTwo(){
        q2 = new Random().nextInt(100);
        q2_2 = new Random().nextInt(100);
        PopulateField2(q2, q2_2);
    }

}