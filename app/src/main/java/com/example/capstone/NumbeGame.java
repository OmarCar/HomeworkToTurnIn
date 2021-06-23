package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumbeGame extends AppCompatActivity {

    Integer[] numbers = {R.drawable.one, R.drawable.two,R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven,R.drawable.eight, R.drawable.nine};
    Integer[] inverseNumbers = {R.drawable.inverseone,R.drawable.inversetwo, R.drawable.inversethree, R.drawable.inversefour, R.drawable.inversefive,
            R.drawable.inversesix, R.drawable.inverseseven, R.drawable.inverseeight, R.drawable.inversenine};
    String[] stringNums = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    Dictionary<Integer, String> combo;
    ImageView[] holders = new ImageView[9];
    Integer[] answers = new Integer[9];
    ImageView answer;
    TextView selected;
    Map map = new HashMap();
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbe_game);
        answer = findViewById(R.id.answerButton);
        //answer.setVisibility(View.INVISIBLE);
        //holders.get(1).setImageResource(numbers[1]);
        //PopulateField();
        PopulateArray();
        selected = findViewById(R.id.display_tv);
        answer.setImageResource(R.drawable.one);
        Button firstLevel = findViewById(R.id.firstLevel_btn);
        firstLevel.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                LevelOne();
            }
        });

        Button levelTwo = findViewById(R.id.levelTwo_btn);
        levelTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LevelTwo();
            }
        });

        ImageView numOne = findViewById(R.id.holderOne);
        numOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintSelected(numOne);
            }
        });
        ImageView numTwo = findViewById(R.id.holderTwo);
        numTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintSelected(numTwo);
            }
        });
        ImageView numThree = findViewById(R.id.holderThree);
        numThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintSelected(numThree);
            }
        });
        ImageView numFour = findViewById(R.id.holderFour);
        numFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintSelected(numFour);
            }
        });
        ImageView numFive = findViewById(R.id.holderFive);
        numFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintSelected(numFive);
            }
        });
        ImageView numSix = findViewById(R.id.holderSix);
        numSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintSelected(numSix);
            }
        });
        ImageView numSeven = findViewById(R.id.holderSeven);
        numSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintSelected(numSeven);
            }
        });
        ImageView numEight = findViewById(R.id.holderEight);
        numEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintSelected(numEight);
            }
        });
        ImageView numNine = findViewById(R.id.holderNine);
        numNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintSelected(numNine);
            }
        });



    }

    public void PopulateArray(){
        holders[0] = findViewById(R.id.holderOne);
        holders[1] = findViewById(R.id.holderTwo);
        holders[2] = findViewById(R.id.holderThree);
        holders[3] = findViewById(R.id.holderFour);
        holders[4] = findViewById(R.id.holderFive);
        holders[5] = findViewById(R.id.holderSix);
        holders[6] = findViewById(R.id.holderSeven);
        holders[7] = findViewById(R.id.holderEight);
        holders[8] = findViewById(R.id.holderNine);

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

    public void Answers(Integer[] array){

    }
    public void LevelTwo(){
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
        answer.setImageResource(answers[count]);
        if(img.getDrawable().getConstantState().equals(answer.getDrawable().getConstantState())){
            selected.append((count + 1) + " ");
            count++;
            answer.setImageResource(answers[count]);
        }else {
            selected.setText("Wrong Answer!");
        }


    }

}