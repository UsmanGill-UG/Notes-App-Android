package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;

public class editnotecache extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editnotecache);

        Button b = findViewById(R.id.cac_add_bt);
        EditText Title = findViewById(R.id.cac_edittxt);
        EditText note = findViewById(R.id.cac_multitxt);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    File cache =getCacheDir();
                    File f = new File(cache,"cache_notes.txt");
                    FileOutputStream fo = new FileOutputStream(f,true); // true == in append mode
                    String title = Title.getText().toString();
                    String note1 = note.getText().toString();
                    JSONObject k = new JSONObject();
                    k.put("title",title);
                    k.put("note",note1);
                    String j = k.toString();
                    Toast.makeText(getApplicationContext(),"Data Saved",Toast.LENGTH_SHORT).show();
                    fo.write(j.getBytes());
                    fo.write('\n');
                    fo.close();
                    finish();
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }
}