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


public class ColorFragment extends Fragment {
    int[] Fragcolors;
    String[] FragcolorIndex;
    int counter, count, checkText;
    ImageView holderCOne,holderCTwo,holderCThree,holderCFour;
    ImageView selectColor;
    TextView colorToWin;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_color, container, false);
        Fragcolors = new int[11];
        FragcolorIndex = new String[11];
        PopulateColorArray();
        selectColor = view.findViewById(R.id.FragselectColor_imgV);
        colorToWin = view.findViewById(R.id.fragSelectColor_tv);
        counter = 0;
        count = 0;
        checkText = 0;

        //int decider = new Random().nextInt(1);

        holderCOne = view.findViewById(R.id.FragcolorOne_img);
        holderCTwo = view.findViewById(R.id.FragcolorTwo_img);
        holderCThree = view.findViewById(R.id.FragcolorThree_img);
        holderCFour = view.findViewById(R.id.FragcolorFour_img);
        LevelOne();
        holderCOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckIfWon(holderCOne);
            }
        });
        holderCTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckIfWon(holderCTwo);
            }
        });
        holderCThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckIfWon(holderCThree);
            }
        });
        holderCFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckIfWon(holderCFour);
            }
        });

        return view;
    }

    public void PopulateColorArray(){
        //{R.drawable.blue, R.drawable.green, R.drawable.orange, R.drawable.pink, R.drawable.red, R.drawable.yellow, R.drawable.brown, R.drawable.navyblue, R.drawable.purple, R.drawable.grey, R.drawable.skyblue}
        Fragcolors[0] = R.drawable.blue;
        Fragcolors[1] = R.drawable.green;
        Fragcolors[2] = R.drawable.orange;
        Fragcolors[3] = R.drawable.pink;
        Fragcolors[4] = R.drawable.red;
        Fragcolors[5] = R.drawable.yellow;
        Fragcolors[6] = R.drawable.brown;
        Fragcolors[7] = R.drawable.navyblue;
        Fragcolors[8] = R.drawable.purple;
        Fragcolors[9] = R.drawable.grey;
        Fragcolors[10] = R.drawable.skyblue;
        //{"blue", "green","orange", "pink","red","yellow","brown","navyblue","purple","grey","skyblue"}
        FragcolorIndex[0] = "blue";
        FragcolorIndex[1] = "green";
        FragcolorIndex[2] = "orange";
        FragcolorIndex[3] = "pink";
        FragcolorIndex[4] = "red";
        FragcolorIndex[5] = "yellow";
        FragcolorIndex[6] = "brown";
        FragcolorIndex[7] = "navyblue";
        FragcolorIndex[8] = "purple";
        FragcolorIndex[9] = "grey";
        FragcolorIndex[10] = "skyblue";
    }

    public void LevelOne(){
        int color1 = new Random().nextInt(10);
        int color2 = new Random().nextInt(10);
        int color3 = new Random().nextInt(10);
        int color4 = new Random().nextInt(10);

        while (color1 == color2 || color3 == color4 || color2 == color4 || color1 == color4 || color2 == color3 || color1 == color3){
            color1 = new Random().nextInt(10);
            color2 = new Random().nextInt(10);
            color3 = new Random().nextInt(10);
            color4 = new Random().nextInt(10);
        }
        int[] array  = new int[4];
        array[0] = color1;
        array[1] = color2;
        array[2] = color3;
        array[3] = color4;
        holderCOne.setImageResource(Fragcolors[color1]);
        holderCTwo.setImageResource(Fragcolors[color2]);
        holderCThree.setImageResource(Fragcolors[color3]);
        holderCFour.setImageResource(Fragcolors[color4]);
        Random rand = new Random();
        int winner = rand.nextInt(4);
        selectColor.setImageResource(Fragcolors[array[winner]]);
    }
    /*
    public void LevelTwo(){

        int color1 = new Random().nextInt(10);
        int color2 = new Random().nextInt(10);
        int color3 = new Random().nextInt(10);
        int color4 = new Random().nextInt(10);

        Random wordOrColor = new Random();


        while (color1 == color2 || color3 == color4 || color2 == color4 || color1 == color4 || color2 == color3 || color1 == color3){
            color1 = new Random().nextInt(10);
            color2 = new Random().nextInt(10);
            color3 = new Random().nextInt(10);
            color4 = new Random().nextInt(10);
        }
        int[] array  = {color1, color2, color3, color4};
        holderCOne.setImageResource(Fragcolors[color1]);
        holderCTwo.setImageResource(Fragcolors[color2]);
        holderCThree.setImageResource(Fragcolors[color3]);
        holderCFour.setImageResource(Fragcolors[color4]);
        int winner = new Random().nextInt(4);
        int check = wordOrColor.nextInt(2);
        if(check == 1 && counter > 0){
            selectColor.setVisibility(View.INVISIBLE);
            selectColor.setImageResource(Fragcolors[array[winner]]);
            colorToWin.setVisibility(View.VISIBLE);
            colorToWin.setText("" + FragcolorIndex[array[winner]]);


        } else {
            colorToWin.setVisibility(View.INVISIBLE);
            colorToWin.setText("" + FragcolorIndex[array[winner]]);
            selectColor.setVisibility(View.VISIBLE);
            selectColor.setImageResource(Fragcolors[array[winner]]);
        }


    }

     */
    public void CheckIfWon(ImageView selectedImage){
        if(selectedImage.getDrawable().getConstantState().equals(selectColor.getDrawable().getConstantState())){
            count = new Random().nextInt(4);
            if(count == 2) {
                LevelOne();
                ((ChallengeMode)getActivity()).setViewPager(count);
            }
            else if(count == 0) {
                LevelOne();
                ((ChallengeMode)getActivity()).setViewPager(0);
            } else if(count == 3)
                ((ChallengeMode)getActivity()).setViewPager(3);
            else
                ((ChallengeMode)getActivity()).setViewPager(3);
        } else{
            Toast toast = Toast.makeText(this.getContext(), "WRONG ANSWER", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}