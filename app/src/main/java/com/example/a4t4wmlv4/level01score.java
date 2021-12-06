package com.example.a4t4wmlv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class level01score extends AppCompatActivity {

    Button btn;
    String username;
    private String points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level01score);


        username  =  getIntent().getStringExtra("uName");
        points = getIntent().getStringExtra("points");

        Toast.makeText(this,points,Toast.LENGTH_SHORT).show();


        btn =(Button) findViewById(R.id.next);
    }

    public void nextRound(View view) {

        Intent intent = getIntent();
        String Next = intent.getStringExtra("Next");
        int i = Integer.parseInt(Next);

        if (i == 1) {
            Intent intent2 = new Intent(level01score.this, level01Int2.class);
            intent2.putExtra("uName",username);
            intent2.putExtra("points",points);
            startActivity(intent2);
        } else if (i == 2) {
            Intent intent3 = new Intent(level01score.this, level01Int3.class);
            intent3.putExtra("uName",username);
            intent3.putExtra("points",points);

            startActivity(intent3);



        }
    }}
