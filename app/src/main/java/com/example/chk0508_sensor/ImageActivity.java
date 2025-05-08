package com.example.chk0508_sensor;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.chk0508_sensor.databinding.ActivityImageBinding;

public class ImageActivity extends AppCompatActivity {
    ActivityImageBinding binding;
    float prev_x = 0f;
    float prev_y = 0f;
    float x = 0f;
    float y = 0f;

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


        binding.imageSmile.setX(binding.main.getWidth()/2 - binding.imageSmile.getWidth()/2);
        binding.imageSmile.setY(binding.main.getHeight()/2 - binding.imageSmile.getHeight()/2);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        ImageView img = binding.imageSmile;

        prev_x = img.getX() - img.getWidth();
        prev_y = img.getY() - img.getHeight();

        x = event.getX() - img.getWidth() /2;
        y = event.getY() - img.getHeight()/2;



        switch (event.getAction()){
            case MotionEvent.ACTION_MOVE:
                img.setX(x);
                img.setY(y);
                break;

            case MotionEvent.ACTION_DOWN:
                ObjectAnimator smileX = ObjectAnimator.ofFloat(img, "translationX", prev_x, x);
                smileX.start();
                ObjectAnimator smileY = ObjectAnimator.ofFloat(img, "translationY", prev_y, y);
                smileY.start();
                break;
        }

        binding.imageViewing.setText("x: "+ x + ", y: " + y);
        return false;
    }

}