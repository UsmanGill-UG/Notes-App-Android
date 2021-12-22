package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class Viewnote extends AppCompatActivity {

    TextView title,body;
    String T,B;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewnote);
        title = findViewById(R.id.tv_viewonly_title);
        body = findViewById(R.id.tv_viewonly_b);
        T = getIntent().getStringExtra("title");
        B= getIntent().getStringExtra("note");
        title.setText(T);
        title.setTextColor(Color.parseColor("#000000"));
        body.setText(B);
        body.setTextColor(Color.parseColor("#000000"));
    }
}