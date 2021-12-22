package com.example.notes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
public class editnote extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editnote);
        Button add = findViewById(R.id.add_editnote_bt);
        EditText Title = findViewById(R.id.plaintext);
        EditText notetext = findViewById(R.id.multitext);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fo = openFileOutput("internalnote123.txt",MODE_APPEND);
                    String title = Title.getText().toString();
                    String body = notetext.getText().toString();
                    JSONObject k = new JSONObject();
                    k.put("title",title);
                    k.put("note",body);
                    String j = k.toString();
//                    JSONArray arr= new JSONArray();
//                    arr.put(k);
//                    Log.d("***","^^ array: "+ arr.toString());
//                    Log.d("****","***** Data Saved Successfully: "+j);
                    Toast.makeText(getApplicationContext(),"Data Saved",Toast.LENGTH_SHORT).show();
                    fo.write(j.getBytes());
                    fo.write('\n');
                    fo.close();
                    finish();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}