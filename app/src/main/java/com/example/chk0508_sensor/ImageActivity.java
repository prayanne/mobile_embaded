package com.example.chk0508_sensor;

import android.os.Bundle;
import android.view.MotionEvent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.chk0508_sensor.databinding.ActivityImageBinding;

public class ImageActivity extends AppCompatActivity {
    ActivityImageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX() - binding.imageSmile.getWidth() /2;
        int y = (int)event.getY() - binding.imageSmile.getHeight()/2;

        switch (event.getAction()){
            case MotionEvent.ACTION_MOVE:
                binding.imageSmile.setX(x);
                binding.imageSmile.setY(y);
        }
        binding.imageViewing.setText("x: "+ x + ", y: " + y);
        return false;
    }

}