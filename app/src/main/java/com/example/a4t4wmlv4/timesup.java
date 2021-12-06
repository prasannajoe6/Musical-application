package com.example.a4t4wmlv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class timesup extends AppCompatActivity {

    Button btn;
    String points,username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timesup);
        points = getIntent().getStringExtra("points");
        username = getIntent().getStringExtra("uName");

        btn = findViewById(R.id.gobackti);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBacktime(view);
            }
        });

    }

    public void goBacktime(View v)
    {
        Intent a = getIntent();
        String previous = a.getStringExtra("From_activity_time");
        int i = Integer.parseInt(previous);
        if(i == 1) {
            Intent intent1 = new Intent(timesup.this, level04_01.class);
            intent1.putExtra("uName",username);
            startActivity(intent1);
            //finish();
        }
        else if(i == 2)
        {
            Intent intent2 = new Intent(timesup.this, level04S2.class);
            intent2.putExtra("uName",username);
            startActivity(intent2);
        }
        else if(i == 3)
        {
            Intent intent3 = new Intent(timesup.this, level04_int03.class);
            intent3.putExtra("uName",username);
            startActivity(intent3);
        }
        else if(i == 4)
        {
            Intent intent4 = new Intent(this, level04_int04.class);
            intent4.putExtra("uName",username);
            startActivity(intent4);
        }
        else if(i == 5)
        {
            Intent intent5 = new Intent(this, level03_int01.class);
            intent5.putExtra("uName",username);
            startActivity(intent5);
        }
        else if(i == 6)
        {
            Intent intent6 = new Intent(this, level03_int02.class);
            intent6.putExtra("uName",username);
            startActivity(intent6);
        }
        else if(i == 7)
        {
            Intent intent7 = new Intent(this, level03_int03.class);
            intent7.putExtra("uName",username);
            startActivity(intent7);
        }
        else if(previous == "lvl2_1")
        {
            Intent intent = new Intent(this, level2_int1.class);
            startActivity(intent);
        }
        else if(previous == "lvl2_2")
        {
            Intent intent = new Intent(this, level2_int2.class);
            startActivity(intent);
        }
        else if(previous == "lvl2_3")
        {
            Intent intent = new Intent(this, level2_int3.class);
            startActivity(intent);
        }
    }
}
