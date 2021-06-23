package com.example.capstone;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class FragColorFlash extends Fragment {

    ImageView[] holders;
    ImageView answer;
    TextView selected;
    int count;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_frag_color_flash, container, false);
        holders = new ImageView[12];
        PopulateArray();
        count = 0;
        StartFlashGame();
        answer = view.findViewById(R.id.FragImgAnswer);
        answer.setImageResource(R.drawable.redflash);

        return view;
    }

    public void PopulateArray(){
        holders[0] = view.findViewById(R.id.FragFlashOne);
        holders[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(holders[0]);
            }
        });
        holders[1] = view.findViewById(R.id.FragFlashTwo);
        holders[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(holders[1]);
            }
        });
        holders[2] = view.findViewById(R.id.FragFlashThree);
        holders[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(holders[2]);
            }
        });
        holders[3] = view.findViewById(R.id.FragFlashFour);
        holders[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(holders[3]);
            }
        });
        holders[4] = view.findViewById(R.id.FragFlashFive);
        holders[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(holders[4]);
            }
        });
        holders[5] = view.findViewById(R.id.FragFlashSix);
        holders[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(holders[5]);
            }
        });
        holders[6] = view.findViewById(R.id.FragFlashSeven);
        holders[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(holders[6]);
            }
        });
        holders[7] = view.findViewById(R.id.FragFlashEight);
        holders[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(holders[7]);
            }
        });
        holders[8] = view.findViewById(R.id.FragFlashNine);
        holders[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(holders[8]);
            }
        });
        holders[9] = view.findViewById(R.id.FragFlashTen);
        holders[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(holders[9]);
            }
        });
        holders[10] = view.findViewById(R.id.FragFlashEleven);
        holders[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(holders[10]);
            }
        });
        holders[11] = view.findViewById(R.id.FragFlashTwelve);
        holders[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(holders[11]);
            }
        });
    }

    public void StartFlashGame(){
        int rand = new Random().nextInt(12);
        holders[rand].setImageResource(R.drawable.redflash);
    }

    public void CheckAnswer(ImageView img){
        if(count != 3){
            if(img.getDrawable().getConstantState().equals(answer.getDrawable().getConstantState())){
                count++;
                img.setImageResource(0);
                StartFlashGame();
            } else if(img.getDrawable().getConstantState().equals(null)){
                Toast toast = Toast.makeText(this.getContext(), "WRONG ANSWER", Toast.LENGTH_LONG);
                toast.show();
            } else if (count == 3){
                GoToNewFrag();
            }
        } else
            GoToNewFrag();
    }

    public void GoToNewFrag(){
        int decider = new Random().nextInt(3);
        if(decider == 2){
            ((ChallengeMode)getActivity()).setViewPager(decider);
        } else if(decider == 1){
            ((ChallengeMode)getActivity()).setViewPager(decider);
        } else
            ((ChallengeMode)getActivity()).setViewPager(decider);
    }


}