package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ColorGame extends AppCompatActivity {

    int[] colors = {R.drawable.blue,R.drawable.green, R.drawable.orange, R.drawable.pink, R.drawable.red,R.drawable.yellow, R.drawable.brown,R.drawable.navyblue,R.drawable.purple,R.drawable.grey,R.drawable.skyblue};
    String[] colorIndex = {"blue", "green","orange", "pink","red","yellow","brown","navyblue","purple","grey","skyblue"};
    Random rand = new Random();
    Random rand2 = new Random();
    Random rand3 = new Random();
    Random rand4 = new Random();
    Random rand5 = new Random();
    int points = 0;
    int counter = 0;
    int checkText = 0;
    ImageView holderCOne,holderCTwo,holderCThree,holderCFour;
    ImageView selectColor;
    TextView colorToWin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_game);
        Button levelOne = findViewById(R.id.levelOne_btn);
        Button levelTwo = findViewById(R.id.levelTwoColors_btn);
        selectColor = findViewById(R.id.selectColor_imgV);
        colorToWin = findViewById(R.id.colorToWin_txt);

        levelOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = 0;
                LevelOne();
            }
        });

        levelTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = 1;
                LevelTwo();
            }
        });



        holderCOne = findViewById(R.id.colorOne_img);
        holderCOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckIfWon(holderCOne);
            }
        });
        holderCTwo = findViewById(R.id.colorTwo_img);
        holderCTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckIfWon(holderCTwo);
            }
        });
        holderCThree = findViewById(R.id.colorThree_img);
        holderCThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckIfWon(holderCThree);
            }
        });
        holderCFour = findViewById(R.id.colorFour_img);
        holderCFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckIfWon(holderCFour);
            }
        });



    }

    public void LevelOne(){
        int color1 = rand.nextInt(10);
        int color2 = rand2.nextInt(10);
        int color3 = rand3.nextInt(10);
        int color4 = rand4.nextInt(10);

        while (color1 == color2 || color3 == color4 || color2 == color4 || color1 == color4 || color2 == color3 || color1 == color3){
            color1 = rand.nextInt(10);
            color2 = rand2.nextInt(10);
            color3 = rand3.nextInt(10);
            color4 = rand4.nextInt(10);
        }
        int[] array  = {color1, color2, color3, color4};
        holderCOne.setImageResource(colors[color1]);
        holderCTwo.setImageResource(colors[color2]);
        holderCThree.setImageResource(colors[color3]);
        holderCFour.setImageResource(colors[color4]);
        int winner = rand5.nextInt(4);
        selectColor.setImageResource(colors[array[winner]]);
    }
    public void LevelTwo(){

        int color1 = rand.nextInt(10);
        int color2 = rand2.nextInt(10);
        int color3 = rand3.nextInt(10);
        int color4 = rand4.nextInt(10);

        Random wordOrColor = new Random();


        while (color1 == color2 || color3 == color4 || color2 == color4 || color1 == color4 || color2 == color3 || color1 == color3){
            color1 = rand.nextInt(10);
            color2 = rand2.nextInt(10);
            color3 = rand3.nextInt(10);
            color4 = rand4.nextInt(10);
        }
        int[] array  = {color1, color2, color3, color4};
        holderCOne.setImageResource(colors[color1]);
        holderCTwo.setImageResource(colors[color2]);
        holderCThree.setImageResource(colors[color3]);
        holderCFour.setImageResource(colors[color4]);
        int winner = rand5.nextInt(4);
        int check = wordOrColor.nextInt(2);
        if(check == 1 && counter > 0){
            selectColor.setVisibility(View.INVISIBLE);
            selectColor.setImageResource(colors[array[winner]]);
            colorToWin.setVisibility(View.VISIBLE);
            colorToWin.setText("" + colorIndex[array[winner]]);


        } else {
            colorToWin.setVisibility(View.INVISIBLE);
            selectColor.setVisibility(View.VISIBLE);
            selectColor.setImageResource(colors[array[winner]]);
        }


    }
    public void CheckIfWon(ImageView selectedImage){
        TextView point = findViewById(R.id.pointTracker_txt);
        if(selectedImage.getDrawable().getConstantState().equals(selectColor.getDrawable().getConstantState())){
            points = points + 1;
            point.setText("Points: " + points);
            if(counter > 0)
                LevelTwo();
            else
                LevelOne();
        } else{
            point.setText("No Points");
            if(counter > 0)
                LevelTwo();
            else
                LevelOne();
        }
        checkText = 0;
    }

}