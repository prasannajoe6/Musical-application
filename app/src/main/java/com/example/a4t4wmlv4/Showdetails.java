package com.example.a4t4wmlv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import Database.DBHelper;

public class Showdetails extends AppCompatActivity {
    ListView names;
    DBHelper db = new DBHelper(this);
    Button next ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdetails);

        names = findViewById(R.id.names);
        next = findViewById(R.id.nextpage);
        TextView listView = findViewById(R.id.viewlist01);
        List<String> name = db.getAllnamesOflevel04();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                R.layout.listview,
                R.id.viewlist01,
                name
        );

        names.setAdapter(arrayAdapter);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Showdetails.this,Last.class);
                startActivity(i);
            }
        });
    }
}
