package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class internal1 extends AppCompatActivity {

    TextView NewNote;
    ListView lv;
    TextView tv;
    ArrayList<String> Str_array = new ArrayList<>();
    ArrayAdapter<String> adapter;
    JSONArray jsonarr = new JSONArray();
    @Override
    protected void onResume() {
        super.onResume();
        FileInputStream fln;
        FileInputStream fln2 = null;
        try {
            jsonarr = new JSONArray();
            fln = openFileInput("internalnote123.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fln));
            String line = reader.readLine();
            while(line!=null){
                JSONObject jsonObject = new JSONObject(line);
                jsonarr.put(jsonObject);
                Log.d("***", "*** Line: " + line);
                line = reader.readLine();
            }
            Log.d("***", "*** JsonArray: " + jsonarr.toString());
            Str_array.clear();
            for(int i = 0; i < jsonarr.length(); i++){
                JSONObject obj = jsonarr.getJSONObject(i);
                if(obj.has("title"))
                {
                    String title = obj.getString("title");
                    Str_array.add(title);
                }
            }
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Str_array);
        setContentView(R.layout.activity_internal1);
        lv = findViewById(R.id.lv_internal);
        lv.setAdapter(adapter);
        NewNote = findViewById(R.id.add_bt);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    JSONObject j = jsonarr.getJSONObject(position);
                    String T = j.getString("title");
                    String B = j.getString("note");
                    Intent i = new Intent(getApplicationContext(),Viewnote.class);
                    i.putExtra("title",T);
                    i.putExtra("note",B);
                    startActivity(i);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        NewNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),editnote.class);
                startActivity(i);

            }
        });
    }
}