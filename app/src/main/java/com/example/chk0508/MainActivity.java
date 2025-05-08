package com.example.chk0508;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.chk0508.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(binding.main.getId()), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setSupportActionBar(binding.toolbar);

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "text1", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        
//        menu.add(0, 1, 0, "red"); //id가 1
//        menu.add(0, 2, 0, "blue");
//        menu.add(0, 3, 0, "green");
//
//        SubMenu sMenu = menu.addSubMenu("cngBtn");
//        sMenu.add(0, 4, 0, "btnR 45");
//        sMenu.add(0, 5, 0, "btnX sx2");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.backR)          { binding.main.setBackgroundColor(Color.RED); return true;}
        else if(item.getItemId() == R.id.backB)     { binding.main.setBackgroundColor(Color.BLUE); return true;}
        else if(item.getItemId() == R.id.backG)     { binding.main.setBackgroundColor(Color.GREEN); return true;}

        else if(item.getItemId() == R.id.subRotate) { binding.btn1.setRotation(45); return true;}
        else if(item.getItemId() == R.id.subSize)   { binding.btn1.setScaleX(2); return true;}

        return false;
    }
}