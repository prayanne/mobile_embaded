package com.example.chk_java;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Log.d("ActivityTest", "onCreate()");

        Button btn1 = (Button) findViewById(R.id.goBackActivity);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this, BackActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityTest", "onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ActivityTest", "onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityTest", "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ActivityTest", "onRestart()");
    }
}