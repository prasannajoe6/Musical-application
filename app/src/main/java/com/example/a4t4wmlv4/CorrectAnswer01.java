package com.example.a4t4wmlv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CorrectAnswer01 extends AppCompatActivity {
    private TextView point;
    MediaPlayer mp;
    String userName;

    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct_answer01);
        userName = getIntent().getStringExtra("uName");

        next=(Button) findViewById(R.id.next1st);
        mp = new MediaPlayer();
        mp = MediaPlayer.create(this,R.raw.correctanswer);
        mp.start();



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextPage(view);
            }
        });
        Intent a = getIntent();
        String previous = a.getStringExtra("From_activity");
        point = (TextView) findViewById(R.id.points);

        if(previous.equals("01"))
        {
            point.setText("10\n"+"POINTS");
        }
        else if(previous.equals("02"))
        {
            point.setText("20\n"+"POINTS");
        }
        else if(previous.equals("03"))
        {
            point.setText("30\n"+"POINTS");
        }
        else if(previous.equals("04"))
        {
            point.setText("40\n"+"POINTS");
        }



    }

    public void nextPage(View v){
        Intent a = getIntent();
        String previous = a.getStringExtra("From_activity");

        mp.stop();
        if(previous.equals("01")) {

            Intent i = new Intent(this, level04S2.class);
            i.putExtra("uName",userName);
            startActivity(i);


        }
        else if(previous.equals("02"))
        {
            Intent i = new Intent(this,level04_int03.class);
            i.putExtra("uName",userName);
            startActivity(i);
        }
        else if(previous.equals("03"))
        {

            Intent i = new Intent(this,level04_int04.class);
            i.putExtra("uName",userName);
            startActivity(i);
        }
        else if(previous.equals("04"))
        {

            Intent i = new Intent(this,Showdetails.class);
            i.putExtra("uName",userName);
            startActivity(i);
        }
    }
}
