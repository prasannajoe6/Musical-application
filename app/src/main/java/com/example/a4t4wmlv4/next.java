package com.example.a4t4wmlv4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

import Database.DBHelper;

public class next extends AppCompatActivity {

    private Button next , back;
    public static MediaPlayer mp;
    private TextView score;
    int points;
    DBHelper dbHelper = new DBHelper(this);
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);


        mp = new MediaPlayer();
        mp = MediaPlayer.create(this,R.raw.correctanswer);
        mp.start();

        next = (Button) findViewById(R.id.next);
        back = (Button) findViewById(R.id.back);
        score = (TextView) findViewById(R.id.score);

        Intent a = getIntent();
        userName = a.getStringExtra("Name");
        String Points = a.getStringExtra("Player Points");

        score.setText(Points);

        points = Integer.parseInt(Points);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NextPage(view);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NextPage(view);
                mp.stop();
            }
        });

    }

    public void NextPage(View v){

        if(v == next ){

            mp.stop();
            if(points == 4){

                int result = dbHelper.insertRound2Score(Integer.toString(points), userName);

                Intent intent = new Intent(next.this, level2_int2.class);
                intent.putExtra("Player Points",points);
                intent.putExtra("Name", userName);
                startActivity(intent);

            }
            else if(points == 10){

                int result = dbHelper.insertRound2Score(Integer.toString(points), userName);

                Intent intent = new Intent(next.this, level2_int3.class);
                intent.putExtra("Player Points",points);
                intent.putExtra("Name", userName);
                startActivity(intent);

            }
            else if(points == 18) {

                int result = dbHelper.insertRound2Score(Integer.toString(points), userName);
                if(result > 0){
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Not Updated", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(this, level03_main.class);

                intent.putExtra("UName", userName);
                startActivity(intent);
            }
        }
        else if(v == back){

            Intent intent = new Intent(next.this, level2.class);
            intent.putExtra("Name", userName);
            startActivity(intent);
            startActivity(intent);
        }
    }


}
