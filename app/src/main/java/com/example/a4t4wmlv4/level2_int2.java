package com.example.a4t4wmlv4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
//import Database.DBHelper;

public class level2_int2 extends AppCompatActivity {
    TextView Tv1_p2 ;
    ImageView iv11,iv12,iv13,iv14,iv21,iv22,iv23,iv24,iv31,iv32,iv33,iv34;
    private ImageButton sound;
    private ImageView home2;

    Integer[] cardArray = {101,105,103,102,108,106,101,102,103,106,105,108};

    int sym_101,sym_102,sym_103,sym_105,sym_106,sym_108;
    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;
    int playerPoints = 4 ;
    public static MediaPlayer player;
    boolean isPressed=false;
    CountDownTimer ctdown;
    String userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2_int2);


        player = new MediaPlayer();
        player = MediaPlayer.create(this, R.raw.background);
        //player.setLooping(true);
        player.start();

        final TextView time = (TextView) findViewById(R.id.time);
        ctdown = new CountDownTimer(50000,1000) {
            @Override
            public void onTick(long l) {

                TextView time = (TextView) findViewById(R.id.time);

                time.setText("Seconds remaining : " + DateUtils.formatElapsedTime(l/1000));
            }
            @Override
            public void onFinish() {
                Intent a = new Intent(level2_int2.this, level2timesup.class);
                a.putExtra("Value","2");
                a.putExtra("Name",userName);
                startActivity(a);

            }
        }.start();

        home2 = findViewById(R.id.Iv1);

        sound = (ImageButton) findViewById(R.id.sound);

        Tv1_p2 = (TextView) findViewById(R.id.Tv1_p2);

        iv11 = (ImageView)findViewById(R.id.iv11);
        iv12 = (ImageView)findViewById(R.id.iv12);
        iv13 = (ImageView)findViewById(R.id.iv13);
        iv14 = (ImageView)findViewById(R.id.iv14);
        iv21 = (ImageView)findViewById(R.id.iv21);
        iv22 = (ImageView)findViewById(R.id.iv22);
        iv23 = (ImageView)findViewById(R.id.iv23);
        iv24 = (ImageView)findViewById(R.id.iv24);
        iv31 = (ImageView)findViewById(R.id.iv31);
        iv32 = (ImageView)findViewById(R.id.iv32);
        iv33 = (ImageView)findViewById(R.id.iv33);
        iv34 = (ImageView)findViewById(R.id.iv34);

        iv11.setTag("0");
        iv12.setTag("1");
        iv13.setTag("2");
        iv14.setTag("3");
        iv21.setTag("4");
        iv22.setTag("5");
        iv23.setTag("6");
        iv24.setTag("7");
        iv31.setTag("8");
        iv32.setTag("9");
        iv33.setTag("10");
        iv34.setTag("11");

        //load the card images
        frontOfCardResources();

        //to shuffle cards
        Collections.shuffle(Arrays.asList(cardArray));

        iv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv11, theCard);
            }
        });
        iv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv12, theCard);
            }
        });
        iv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv13, theCard);
            }
        });
        iv14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv14, theCard);

            }
        });
        iv21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv21, theCard);
            }
        });
        iv22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv22, theCard);
            }
        });
        iv23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv23, theCard);
            }
        });
        iv24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv24, theCard);
            }
        });
        iv31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv31, theCard);
            }
        });
        iv32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv32, theCard);
            }
        });
        iv33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv33, theCard);
            }
        });
        iv34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv34, theCard);
            }
        });
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.setBackgroundResource(R.drawable.mute);
                if(isPressed){
                    sound.setBackgroundResource(R.drawable.mute);
                    player.pause();
                }else{
                    sound.setBackgroundResource(R.drawable.sound);
                    player.start();
                }
                isPressed=!isPressed;

            }
        });
        home2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SwitchPage();
                player.pause();

            }
        });

    }
    private void SwitchPage() {
        Intent intent = new Intent(level2_int2.this, level2.class);
        startActivity(intent);
    }


    private void doStuff(ImageView iv, int Card) {

        //set the correct images to the image view
        if (cardArray[Card] == 101) {
            iv.setImageResource(sym_101);
        }
        else if (cardArray[Card] == 102) {
            iv.setImageResource(sym_102);
        }
        else if (cardArray[Card] == 103) {
            iv.setImageResource(sym_103);
        }
        else if (cardArray[Card] == 105) {
            iv.setImageResource(sym_105);
        }
        else if (cardArray[Card] == 106) {
            iv.setImageResource(sym_106);
        }
        else if (cardArray[Card] == 108) {
            iv.setImageResource(sym_108);
        }
        if (cardNumber == 1) {
            firstCard = cardArray[Card];

            cardNumber = 2;
            clickedFirst = Card;

            iv.setEnabled(false);

        } else if (cardNumber == 2)
        {
            secondCard = cardArray[Card];

            cardNumber = 1;
            clickedSecond = Card;

            iv11.setEnabled(false);
            iv12.setEnabled(false);
            iv13.setEnabled(false);
            iv14.setEnabled(false);
            iv21.setEnabled(false);
            iv22.setEnabled(false);
            iv23.setEnabled(false);
            iv24.setEnabled(false);
            iv31.setEnabled(false);
            iv32.setEnabled(false);
            iv33.setEnabled(false);
            iv34.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    //check if the selected images are equal
                    calculate();

                }
            }, 1000);
        }
    }

    private void calculate() {
        //if images are equal remove them and add point
        if(firstCard == secondCard){
            if(clickedFirst == 0){
                iv11.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 1){
                iv12.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 2){
                iv13.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 3){
                iv14.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 4){
                iv21.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 5){
                iv22.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 6){
                iv23.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 7){
                iv24.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 8){
                iv31.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 9){
                iv32.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 10){
                iv33.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 11){
                iv34.setVisibility(View.INVISIBLE);
            }

            if(clickedSecond == 0){
                iv11.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 1){
                iv12.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 2){
                iv13.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 3){
                iv14.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 4){
                iv21.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 5){
                iv22.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 6){
                iv23.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 7){
                iv24.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 8){
                iv31.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 9){
                iv32.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 10){
                iv33.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 11){
                iv34.setVisibility(View.INVISIBLE);
            }

            playerPoints ++;
            Tv1_p2.setText("Points: " +playerPoints);

        }
        else {
            iv11.setImageResource(R.drawable.hidden);
            iv12.setImageResource(R.drawable.hidden);
            iv13.setImageResource(R.drawable.hidden);
            iv14.setImageResource(R.drawable.hidden);
            iv21.setImageResource(R.drawable.hidden);
            iv22.setImageResource(R.drawable.hidden);
            iv23.setImageResource(R.drawable.hidden);
            iv24.setImageResource(R.drawable.hidden);
            iv31.setImageResource(R.drawable.hidden);
            iv32.setImageResource(R.drawable.hidden);
            iv33.setImageResource(R.drawable.hidden);
            iv34.setImageResource(R.drawable.hidden);
            Vibratee();

        }
        iv11.setEnabled(true);
        iv12.setEnabled(true);
        iv13.setEnabled(true);
        iv14.setEnabled(true);
        iv21.setEnabled(true);
        iv22.setEnabled(true);
        iv23.setEnabled(true);
        iv24.setEnabled(true);
        iv31.setEnabled(true);
        iv32.setEnabled(true);
        iv33.setEnabled(true);
        iv34.setEnabled(true);

        //check if the game is over
        checkEnd();
    }

    private void checkEnd() {

        if(iv11.getVisibility() == View.INVISIBLE &&
                iv11.getVisibility() == View.INVISIBLE &&
                iv12.getVisibility() == View.INVISIBLE &&
                iv13.getVisibility() == View.INVISIBLE &&
                iv14.getVisibility() == View.INVISIBLE &&
                iv21.getVisibility() == View.INVISIBLE &&
                iv22.getVisibility() == View.INVISIBLE &&
                iv23.getVisibility() == View.INVISIBLE &&
                iv24.getVisibility() == View.INVISIBLE &&
                iv31.getVisibility() == View.INVISIBLE &&
                iv32.getVisibility() == View.INVISIBLE &&
                iv33.getVisibility() == View.INVISIBLE &&
                iv34.getVisibility() == View.INVISIBLE ){


            //get the intent and sent the values to another activity
            player.stop();
            ctdown.cancel();
            Intent a = getIntent();
            userName = a.getStringExtra("Name");
            Intent intent = new Intent(this, next.class);
            String point = Integer.toString(playerPoints);
            intent.putExtra("Player Points",point);
            intent.putExtra("Name", userName);
            startActivity(intent);
        }


    }

    private void frontOfCardResources() {

        sym_101 = R.drawable.sym_101;
        sym_102 = R.drawable.sym_102;
        sym_103 = R.drawable.sym_103;
        sym_105 = R.drawable.sym_105;
        sym_106 = R.drawable.sym_106;
        sym_108 = R.drawable.sym_108;


    }
    //vibreate to the wrong matches
    private void Vibratee() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(150,10));
        } else {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(150);
        }
    }
}
