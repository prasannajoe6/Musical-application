package com.example.a4t4wmlv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Database.DBHelper;

public class level03_int03 extends AppCompatActivity {

    private Button home, ok;
    private double answer = 0.25;
    String userName;
    int points = 0;
    CountDownTimer ctdown;
    DBHelper db = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level03_int03);

        points = getIntent().getIntExtra("points", 0);
        userName = getIntent().getStringExtra("uName");

        final TextView time = (TextView) findViewById(R.id.lvl3time3);
         ctdown = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long l) {

                TextView time = (TextView) findViewById(R.id.lvl3time3);

                time.setText("Time remaining : " + DateUtils.formatElapsedTime(l/1000));
            }

            @Override
            public void onFinish() {
                Intent a = new Intent(level03_int03.this,timesup.class);
                a.putExtra("From_activity","7");
                startActivity(a);

            }
        }.start();

        home = (Button) findViewById(R.id.lvl3Homebtn);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(level03_int03.this, level03_main.class);
                startActivity(i);
                ctdown.cancel();
            }
        });

        ok = (Button) findViewById(R.id.cnfBtn);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText = findViewById(R.id.editTextMul);

                if(Double.parseDouble(editText.getText().toString()) == answer) {
                    points = points + 4;
                    Intent intent = new Intent(level03_int03.this, level04Main.class);
                    intent.putExtra("uName", userName);
                    int result = db.insertRound3Score(points, userName);
                    if(result > 0){
                        Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Not Updated", Toast.LENGTH_SHORT).show();
                    }
                    startActivity(intent);
                    ctdown.cancel();

                    editText.setText("");
                }else{
                    Toast.makeText(level03_int03.this, "Wrong answer", Toast.LENGTH_SHORT).show();
                    editText.setText("");
                    Vibratee();
                }
            }
        });

    }
    private void Vibratee() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(150,10));
        } else {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(150);
        }
    }

}
