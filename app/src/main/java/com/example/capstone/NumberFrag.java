package com.example.capstone;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class NumberFrag extends Fragment {
    Integer[] numbers = {R.drawable.one, R.drawable.two,R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven,R.drawable.eight, R.drawable.nine};
    Integer[] inverseNumbers = {R.drawable.inverseone,R.drawable.inversetwo, R.drawable.inversethree, R.drawable.inversefour, R.drawable.inversefive,
            R.drawable.inversesix, R.drawable.inverseseven, R.drawable.inverseeight, R.drawable.inversenine};
    ImageView[] holders = new ImageView[9];
    Integer[] answers = new Integer[9];
    ImageView answer;
    TextView selected;
    int count;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_number, container, false);
        count = 0;

        answer = view.findViewById(R.id.fragNumAnswer);
        answer.setVisibility(View.INVISIBLE);
        //holders.get(1).setImageResource(numbers[1]);
        //PopulateField();
        PopulateArray();
        selected = view.findViewById(R.id.fragTVAnswers);
        /*
        int decider = new Random().nextInt(1);
        if(decider == 1)
            LevelTwo();
        else
            LevelOne();
         */
        LevelOne();
        ImageView numOne = view.findViewById(R.id.FragholderOne);
        numOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintSelected(numOne);
            }
        });
        ImageView numTwo = view.findViewById(R.id.FragholderTwo);
        numTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintSelected(numTwo);
            }
        });
        ImageView numThree = view.findViewById(R.id.FragholderThree);
        numThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintSelected(numThree);
            }
        });
        ImageView numFour = view.findViewById(R.id.FragholderFour);
        numFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintSelected(numFour);
            }
        });
        ImageView numFive = view.findViewById(R.id.FragholderFive);
        numFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintSelected(numFive);
            }
        });
        ImageView numSix = view.findViewById(R.id.FragholderSix);
        numSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintSelected(numSix);
            }
        });
        ImageView numSeven = view.findViewById(R.id.FragholderSeven);
        numSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintSelected(numSeven);
            }
        });
        ImageView numEight = view.findViewById(R.id.FragholderEight);
        numEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintSelected(numEight);
            }
        });
        ImageView numNine = view.findViewById(R.id.FragholderNine);
        numNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintSelected(numNine);
            }
        });


        return view;
    }

    public void PopulateArray(){
        holders[0] = view.findViewById(R.id.FragholderOne);
        holders[1] = view.findViewById(R.id.FragholderTwo);
        holders[2] = view.findViewById(R.id.FragholderThree);
        holders[3] = view.findViewById(R.id.FragholderFour);
        holders[4] = view.findViewById(R.id.FragholderFive);
        holders[5] = view.findViewById(R.id.FragholderSix);
        holders[6] = view.findViewById(R.id.FragholderSeven);
        holders[7] = view.findViewById(R.id.FragholderEight);
        holders[8] = view.findViewById(R.id.FragholderNine);

    }

    public void LevelOne(){
        count = 0;
        selected.setText("");
        Integer[] scramArray = ScrambleArray(numbers, inverseNumbers);
        List<Integer> intList = Arrays.asList(scramArray);
        Collections.shuffle(intList);
        intList.toArray();
        PopulateTable(intList);
    }

    public void LevelTwo(){
        count = 0;
        selected.setText("");
        Integer[] scramArray = inverseNumbers;
        List<Integer> intList = Arrays.asList(scramArray);
        Collections.shuffle(intList);
        intList.toArray();
        PopulateTable(intList);
    }

    public void PopulateTable(List<Integer> array){
        int x = 0;

        while (x < 9){
            holders[x].setImageResource(array.get(x));
            x++;
        }
    }
    public Integer[] ScrambleArray(Integer[] numbers, Integer[] inverseNumbers){
        Integer[] returnArray = new Integer[9];
        for(int x = 0; x < 9; x++){
            if(x % 2 == 0){
                returnArray[x] = numbers[x];
                answers[x] = numbers[x];
            } else{
                returnArray[x] = inverseNumbers[x];
                answers[x] = inverseNumbers[x];
            }
        }
        return returnArray;
    }

    public void PrintSelected(ImageView img){
        if(count != 8){
            answer.setImageResource(answers[count]);
            if(img.getDrawable().getConstantState().equals(answer.getDrawable().getConstantState())){
                selected.append((count + 1) + " ");
                count++;
                answer.setImageResource(answers[count]);
                answer.setVisibility(View.INVISIBLE);
            }else {
                count = 0;
                LevelOne();
                ((ChallengeMode)getActivity()).setViewPager(0);
            }
        } else {
            int decider = new Random().nextInt(4);
            if(decider == 0)
                ((ChallengeMode)getActivity()).setViewPager(decider);
            else if(decider == 1)
                ((ChallengeMode)getActivity()).setViewPager(decider);
            else
                ((ChallengeMode)getActivity()).setViewPager(3);
        }

    }
}