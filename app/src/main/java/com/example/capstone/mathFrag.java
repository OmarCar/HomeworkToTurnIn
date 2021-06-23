package com.example.capstone;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class mathFrag extends Fragment {
    TextView fragQ1;
    EditText fragQA;
    int fQ1, fQ1_2, fQ1_A, count;
    Random rand, rand2;
    Button checkA;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_math, container, false);
        checkA = view.findViewById(R.id.fragCheckA);
        fragQ1 = view.findViewById(R.id.fragQOne_tv);
        fragQA = view.findViewById(R.id.fragEnterAnswerOne);
        fQ1_A = 0;
        rand = new Random();
        rand2 = new Random();
        fQ1 = rand.nextInt(10);
        fQ1_2 = rand2.nextInt(10);
        PopulateField();
        checkA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswerOne();
            }
        });


        return view;
    }

    public void CheckAnswerOne(){
        fQ1_A = Integer.parseInt(fragQA.getText().toString());
        if(fQ1_A == fQ1+fQ1_2){
            PopulateField();
            count = new Random().nextInt(4);
            if(count == 1){
                fQ1 = rand.nextInt(10);
                fQ1_2 = rand2.nextInt(10);
                PopulateField();
                ((ChallengeMode)getActivity()).setViewPager(count);
            } else if(count == 2){
                fQ1 = rand.nextInt(10);
                fQ1_2 = rand2.nextInt(10);
                PopulateField();
                ((ChallengeMode)getActivity()).setViewPager(count);
            } else
                fQ1 = rand.nextInt(10);
                fQ1_2 = rand2.nextInt(10);
                PopulateField();
                ((ChallengeMode)getActivity()).setViewPager(3);
        } else{
            fQ1 = rand.nextInt(10);
            fQ1_2 = rand2.nextInt(10);
            PopulateField();
            ((ChallengeMode)getActivity()).setViewPager(0);
        }
    }

    public void Increment(int qA, int q_H){
        fQ1 = q_H;
        fQ1_2 = qA;
        fragQ1.setText(fQ1 + " + " + fQ1_2);

    }

    public void PopulateField(){
        fragQ1.setText(fQ1 + " + " + fQ1_2);
    }
}