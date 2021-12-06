package com.example.a4t4wmlv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.format.DateUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import Database.DBHelper;

public class level01Int3 extends AppCompatActivity {

    Button homebutton,back,next;
    TextView showValue;
    CountDownTimer ctdown;
    int counter = 0;
    String username;
    private String points;
    DBHelper dbHelper = new DBHelper(this);
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level01_int3);

        username  =  getIntent().getStringExtra("uName");
        points = getIntent().getStringExtra("points");


        //adding timer
        final TextView time = (TextView) findViewById(R.id.time);
        ctdown = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {

                TextView time = (TextView) findViewById(R.id.time);
                time.setText("Seconds remaining : " + DateUtils.formatElapsedTime(l / 1000));
            }

            @Override
            public void onFinish() {

                Intent intent = new Intent(level01Int3.this, level01timesup.class);
                intent.putExtra("Value","3");
                intent.putExtra("uName",username);
                intent.putExtra("points", points);
                startActivity(intent);

            }
        }.start();


        mp = new MediaPlayer();
        mp = MediaPlayer.create(this, R.raw.background);
        //player.setLooping(true);
        mp.start();

        //back to home
        homebutton = findViewById(R.id.home);

        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(level01Int3.this, MainActivity.class);
                intent.putExtra("uName",username);
                startActivity(intent);
            }
        });


        //next round
        next  = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points = "30";

                Intent intent = new Intent(level01Int3.this, level01_complete.class);
                intent.putExtra("Next","3");
                intent.putExtra("uName",username);
                intent.putExtra("points",points);

                int res = (int) dbHelper.insertRound1Score(Integer.parseInt(points),username);
                mp.stop();

                if(res > 0){
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Not Updated", Toast.LENGTH_SHORT).show();
                }

                startActivity(intent);

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        ctdown.cancel();
    }

    //correct image toast
    public  void correct(View view) {

        ctdown.cancel();

        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.correct_toast, (ViewGroup) findViewById(R.id.custom_toast_container));



        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();

        if (counter == 0) {
            counter += 10;
        }
        showValue.setText(Integer.toString(counter));

    }

    //wrong image toast
    public  void wrong(View view) {

        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.wrong_toast, (ViewGroup) findViewById(R.id.custom_toast_container));


        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
        Vibratee();


    }
    private void Vibratee() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(150,10));
        } else {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(150);
        }
    }
}
