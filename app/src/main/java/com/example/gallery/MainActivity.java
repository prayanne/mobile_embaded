package com.example.gallery;

import android.content.Intent;
import android.graphics.Picture;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    void clickDraw(View v){
        int id = v.getId();
        LinearLayout layout = (LinearLayout) v.findViewById(id);
        String tag = (String) layout.getTag();

//        Toast.makeText(this, "클릭한 아이템", Toast.LENGTH_SHORT).show();
        Intent it = new Intent(this, PictureActivity.class);
        it.putExtra("it_tag", tag);
        startActivity(it);
    }

}