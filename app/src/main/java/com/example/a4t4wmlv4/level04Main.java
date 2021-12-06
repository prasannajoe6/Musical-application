package com.example.a4t4wmlv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Database.DBHelper;

public class level04Main extends AppCompatActivity {

    private Button but01 , but02 , but03 , but04 , home;
    DBHelper db = new DBHelper(this);
    String name;
    TextView userN;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level04_main);


        mp = new MediaPlayer();
        mp = MediaPlayer.create(this, R.raw.background);
        //player.setLooping(true);
        mp.start();




        TextView welcome = (TextView) findViewById(R.id.welcome);


        //welcomet.setText();

        Intent a = getIntent();
        name = a.getStringExtra("uName");
        userN = (TextView) findViewById(R.id.welcome);
        userN.setText("All the best "+name+ "!!");


        but01 =(Button) findViewById(R.id.int0104);
        but02 =(Button) findViewById(R.id.int0204);
        but03 =(Button) findViewById(R.id.int0304);
        but04 =(Button) findViewById(R.id.int0404);

        home = (Button) findViewById(R.id.homefromlevel04main);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(level04Main.this, MainActivity.class);
                startActivity(i);

            }
        });

        but01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switchPage(view);

            }
        });

        but02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switchPage(view);

            }
        });
        but03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switchPage(view);

            }
        });
        but04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switchPage(view);

            }
        });
        but01.setEnabled(true);
        but02.setEnabled(false);
        but03.setEnabled(false);
        but04.setEnabled(false);
    }
    public void switchPage (View v){
        mp.stop();
        if(v == but01) {
            Intent intent = new Intent(this, level04_01.class);
            intent.putExtra("Name" , name);
            startActivity(intent);


        }
        else if(v == but02)
        {
            Intent intent = new Intent(this, level04S2.class);
            startActivity(intent);
        }
        else if(v == but03)
        {
            Intent intent = new Intent(this, level03_main.class);
            startActivity(intent);
        }
        else if(v == but04)
        {
            Intent intent = new Intent(this, level04_int04.class);
            startActivity(intent);
        }
    }
}
