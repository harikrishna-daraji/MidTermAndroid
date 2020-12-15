package com.example.midtermexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TAG","Create Called");
        try {
            JsonParser jsonParser = (JsonParser) new JsonParser(this,this).execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}