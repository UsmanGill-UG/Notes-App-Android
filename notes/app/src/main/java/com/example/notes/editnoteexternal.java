package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;

public class editnoteexternal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editnoteexternal);


        // PERMISSIONS
        if(ActivityCompat.checkSelfPermission(editnoteexternal.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)
        {
            //Do nothing
        }
        else
        {
            // get the permission request from user
            ActivityCompat.requestPermissions(editnoteexternal.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}
                    ,0);
        }

        Button b =  findViewById(R.id.ext_add_bt);
        EditText  Title = findViewById(R.id.ext_edittext);
        EditText  note = findViewById(R.id.ext_multitext);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    File docs = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                    File file = new File(docs, "external123.txt");
                    FileOutputStream fo = new FileOutputStream(file, true);
                    String title = Title.getText().toString();
                    String note1 = note.getText().toString();
                    JSONObject k = new JSONObject();
                    k.put("title",title);
                    k.put("note",note1);
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
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });


    }
}