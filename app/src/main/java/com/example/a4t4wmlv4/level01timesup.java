package com.example.a4t4wmlv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class level01timesup extends AppCompatActivity {

    Button btn;
    String points,username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level01timesup);

        btn =(Button) findViewById(R.id.goback);
        points = getIntent().getStringExtra("points");
        username = getIntent().getStringExtra("uName");


    }

    public void goBack(View view){

        Intent intent = getIntent();
        String value = intent.getStringExtra("Value");
        int i = Integer.parseInt(value);

        if(i == 1){
            Intent intent2 = new Intent(level01timesup.this,level1.class);
            intent.putExtra("uName",username);
            intent.putExtra("points", points);
            startActivity(intent2);
        }else if(i == 2){
            Intent intent3 = new Intent(level01timesup.this,level01Int2.class);
            intent.putExtra("uName",username);
            intent.putExtra("points", points);

            startActivity(intent3);
        }else if(i == 3){
            Intent intent4 = new Intent(level01timesup.this,level01Int3.class);
            intent.putExtra("uName",username);
            intent.putExtra("points", points);

            startActivity(intent4);
        }


    }


    }


