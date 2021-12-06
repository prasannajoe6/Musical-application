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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import Database.DBHelper;


public class level1 extends AppCompatActivity {

    Button homebutton,back,next,sound;
    ImageButton goBack1;
    ImageView iv1;
    TextView showValue;
    CountDownTimer ctdown;
    DBHelper dbHelper = new DBHelper(this);
    String username;
    boolean isPressed = false;
    MediaPlayer mp;

    private String points = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        username  =  getIntent().getStringExtra("Name");

        mp = new MediaPlayer();
        mp = MediaPlayer.create(this, R.raw.background);
        mp.start();




        //adding timer
        final TextView time = (TextView) findViewById(R.id.time);


        ctdown = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long l) {

                time.setText("Seconds remaining : " + DateUtils.formatElapsedTime(l / 1000));

            }

            @Override
            public void onFinish() {

                Intent intent = new Intent(level1.this, level01timesup.class);
                intent.putExtra("Value","1");
                intent.putExtra("uName",username);
                intent.putExtra("points", points);
                startActivity(intent);

            }

        }.start();


        //adding score
        showValue = (TextView) findViewById(R.id.score);


        //go back
        goBack1=findViewById(R.id.backBTN1);

        goBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(level1.this, mainMenu.class);
                startActivity(intent);
            }
        });


        //back to home
        homebutton = findViewById(R.id.button20);

        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(level1.this, MainActivity.class);
                startActivity(intent);
            }
        });


        //click the correct button
        next  = findViewById(R.id.button10);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points = "10";
                Intent intent = new Intent(level1.this, level01score.class);
                intent.putExtra("Next","1");
                intent.putExtra("points", points);
                intent.putExtra("uName", username);
                int res = dbHelper.insertRound1Score(Integer.parseInt(points),username);
                mp.stop();

                if(res > 0){
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Not Updated", Toast.LENGTH_SHORT).show();
                }

                startActivity(intent);

                ctdown.cancel();

            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        ctdown.cancel();
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

        Vibratee();


    }

    //vibrate
    private void Vibratee() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(150,10));
        } else {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(150);
        }
    }





}