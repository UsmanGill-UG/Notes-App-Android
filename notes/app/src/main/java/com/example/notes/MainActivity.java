package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button internal_bt  = findViewById(R.id.internal_button);
        Button external_bt  = findViewById(R.id.external_button);
        Button cache_bt  = findViewById(R.id.cache_button);


        internal_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent internal_screen_intent = new Intent(getApplicationContext(), internal1.class);
                startActivity(internal_screen_intent);
            }
        });
        external_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent external_screen_intent = new Intent(getApplicationContext(), external.class);
                startActivity(external_screen_intent);
            }
        });
        cache_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cache_screen_intent = new Intent(getApplicationContext(), cache.class);
                startActivity(cache_screen_intent);
            }
        });
    }
}