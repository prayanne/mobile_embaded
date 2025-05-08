package com.example.chk0508_sensor;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.chk0508_sensor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding.goImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        double x = (double)event.getX();
        double y = (double)event.getY();
        x = Double.parseDouble(String.format("%.1f", x));
        y = Double.parseDouble(String.format("%.1f", y));

        String text = "";

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                text = "터치 위치\n x = " + x + ", y = " + y;
                break;
            case MotionEvent.ACTION_MOVE:
                text = "누르고 있는 위치\nx = " + x + ", y = " + y;
                break;
            case MotionEvent.ACTION_UP:
                text = "뗀 위치\nx = " + x + ", y = " + y;
                break;
        }
        binding.textViewing.setText(text);
        return false;
    }
}