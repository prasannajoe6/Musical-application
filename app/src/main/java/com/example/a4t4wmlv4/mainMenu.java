package com.example.a4t4wmlv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class mainMenu extends AppCompatActivity {
    private Button button04 , button03 , button02 , button01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Intent a = getIntent();
        String previous = a.getStringExtra("Name");


        Toast.makeText(this,previous,Toast.LENGTH_SHORT).show();

        //final MediaPlayer mplayer = MediaPlayer.create(this,R.raw.background);

        //mplayer.start();

        button01 =(Button) findViewById(R.id.button_to_level01);
        button02 =(Button) findViewById(R.id.button_to_level2);
        button03 =(Button) findViewById(R.id.button_to_level03);
        button04 = (Button) findViewById(R.id.button_to_level04);

        button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switchPage(view);
                //      mplayer.pause();
            }
        });
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switchPage(view);
                //    mplayer.pause();
            }
        });
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switchPage(view);
                //  mplayer.pause();

            }
        });
//        button03.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                switchPage(view);
//            }
//        });

        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switchPage(view);
                //mplayer.pause();
            }
        });



    }

    public void switchPage (View v){
        if(v == button01) {
            Intent a = getIntent();
            String previous = a.getStringExtra("Name");
            Intent intent = new Intent(this, level1.class);
            intent.putExtra("Name" , previous);
            startActivity(intent);

        }
        else if(v == button02)
        {
            Intent a = getIntent();
            String previous = a.getStringExtra("Name");
            Intent intent = new Intent(this, level2.class);
            intent.putExtra("Name" , previous);
            startActivity(intent);
        }

        else if(v == button03)
        {
            Intent a = getIntent();
            String previous = a.getStringExtra("Name");
            Intent intent = new Intent(this, level03_main.class);
            intent.putExtra("UName", previous);
            startActivity(intent);
        }
        else if(v == button04)
        {
            Intent a = getIntent();
            String previous = a.getStringExtra("Name");
            //Intent intent = new Intent(this, level4.class);
            Intent intent = new Intent(this, level04Main.class);
            intent.putExtra("uName" , previous);
            startActivity(intent);




        }
    }
}


