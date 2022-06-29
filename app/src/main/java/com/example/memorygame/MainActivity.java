package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.os.*;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ImageButton[] button = new ImageButton[12];
    boolean flipped = false;
    int lastClicked=-1;
    int clicked=0;
    Button restart;
    String[] check= {"fox", "monkey", "lion", "camel", "lion", "coala", "coala", "wolf", "camel", "fox", "monkey", "wolf"};
    int[] images = {R.drawable.im3, R.drawable.im5, R.drawable.im10, R.drawable.im1, R.drawable.im4,
            R.drawable.im8, R.drawable.im2, R.drawable.im6, R.drawable.im7, R.drawable.im9, R.drawable.im11, R.drawable.im12};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restart=findViewById(R.id.reset);
        for (int i = 0; i < 12; i++) {
            int c = getResources().getIdentifier("button" + i, "id", getPackageName());
            button[i] = findViewById(c);
            button[i].setTag("cardBack");
            int finalI = i;

            button[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(button[finalI].getTag()=="cardBack" && !flipped){
                        button[finalI].setImageResource(images[finalI]);
                        button[finalI].setTag(check[finalI]);
                        if(clicked==0){
                            lastClicked= finalI;
                        }
                        clicked++;
                    }else if(button[finalI].getTag()!="cardBack"){
                        button[finalI].setImageResource(R.drawable.empty);
                        button[finalI].setTag("cardBack");
                        clicked--;
                    }
                    if(clicked==2){
                        flipped=true;
                        if(button[finalI].getTag()==button[lastClicked].getTag()){
                            button[finalI].setEnabled(false);
                            button[lastClicked].setEnabled(false);
                            flipped=false;
                            clicked=0;
                        }
                    }else if(clicked==0){
                        flipped=false;
                    }
                }
            });
            restart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clicked=0;
                    lastClicked=-1;
                    flipped=false;
                    for(int i = 0; i < 12; i++){
                        button[i].setImageResource(R.drawable.empty);
                        button[i].setTag("cardBack");
                    }
                }
            });
        }
    }
















//    @Override
//    public void onClick(View v) {
//
//
//            for (int i = 0; i < 12; i++) {
//                if (v.getId() == button[i].getId()) {
//                    clicked++;
//                    if(clicked!=2){
//                        button[i].setImageResource(images[i]);
//                        firstCard=button[i].getId();
//                        int j=i+1;
//                        for(j=1;j<2;j++){
//                            if(v.getId()==button[j].getId()){
//                                clicked++;
//                                button[j].setImageResource(images[j]);
//                                secondCard=button[j].getId();
//                                firstCard=firstCard+6;
//                                if(clicked==2){
//                                    checkMatch(firstCard,secondCard);
//                                }
//
//                            }
//                        }
//                    }
//
//                }
//
////                   for (int j=1;j<11;j++){
////                       if(v.getId()==button[j].getId()){clicked++;
////                           if(clicked!=2){
////                               button[j].setImageResource(images[j]);
////                               secondCard= check[j];
////                           }else if(clicked==2){
////                               clicked=0;
////                               if(checkMatch(firstCard,secondCard)){
////                                   button[j+1].setImageResource(R.drawable.empty);
////                               }
////                           }
////
////
////                       }
////            }
//    }
//
//    }
//    public boolean checkMatch(int c1,int c2){
//        if(c1==c2){
//            Toast.makeText(this, "Match", Toast.LENGTH_SHORT).show();
//            return true;
//        }else{
//            Toast.makeText(this, "No Match", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//    }
    


}


