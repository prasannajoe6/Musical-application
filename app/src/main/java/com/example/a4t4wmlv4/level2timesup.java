package com.example.a4t4wmlv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class level2timesup extends AppCompatActivity {

    Button btn;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2timesup);

        btn = (Button) findViewById(R.id.goback);

        username = getIntent().getStringExtra("Name");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goBack(view);
            }
        });
    }
    public void goBack(View view){

        Intent intent = getIntent();
        String value = intent.getStringExtra("Value");
        int i = Integer.parseInt(value);

        if(i == 1){
            Intent intent2 = new Intent(level2timesup.this,level2_int1.class);
            intent.putExtra("Name",username);
            startActivity(intent2);
        }else if(i == 2){
            Intent intent3 = new Intent(level2timesup.this,level2_int2.class);
            intent.putExtra("Name",username);

            startActivity(intent3);
        }else if(i == 3){
            Intent intent4 = new Intent(level2timesup.this,level2_int3.class);
            intent.putExtra("Name",username);

            startActivity(intent4);
        }


    }

}
