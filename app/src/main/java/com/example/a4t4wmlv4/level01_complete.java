package com.example.a4t4wmlv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class level01_complete extends AppCompatActivity {

    Button btn;
    private String points;
    TextView score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level01_complete);

        points = getIntent().getStringExtra("points");

        btn = (Button) findViewById(R.id.nextlevel);
        score = findViewById(R.id.score);

        score.setText(points);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent a = getIntent();
                String userName = a.getStringExtra("uName");
                Intent intent = new Intent(level01_complete.this, level2.class);
                intent.putExtra("Name", userName);
                startActivity(intent);
            }
        });
    }
}
