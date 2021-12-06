package com.example.a4t4wmlv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import Database.DBHelper;
import Database.UsersMaster;

public class level2 extends AppCompatActivity {

    private Button button1,button2;
    private ImageButton sound;
    private TextView userN;
    public static MediaPlayer player;
    boolean isPressed=false;
    String name;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);

        player = new MediaPlayer();
        player = MediaPlayer.create(this, R.raw.background);
        //player.setLooping(true);
        player.start();

        //go to back
        Button btn = (Button) findViewById(R.id.btn5);
        btn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                Intent intent = new Intent(level2.this, mainMenu.class );
                startActivity(intent);
                player.pause();

            }

        });

        ImageButton homebutton = findViewById(R.id.imageView16);

        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(level2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button1 = findViewById(R.id.btn2);
        button2 = findViewById(R.id.btn4);
        sound = findViewById(R.id.sound);

        Intent a = getIntent();
        name = a.getStringExtra("Name");
        userN = findViewById(R.id.username);
        userN.setText("  ");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NextPage(view);
                player.pause();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NextPage(view);
                player.pause();
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


    }
        //go to next page
    public void NextPage (View v){
        if(v == button1) {
            Intent intent = new Intent(this, level2_int1.class);
            intent.putExtra("Name" , name);
            startActivity(intent);
        }
        else if(v == button2) {
            Intent intent = new Intent(this, level2showdetails.class);
            intent.putExtra("Name" , name);
            startActivity(intent);
        }
    }
}