package com.example.chk_java;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chk_java.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView tv1, tv2, tv3;

        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tv1 = (TextView) findViewById(R.id.textview1);
        tv2 = (TextView) findViewById(R.id.textview2);
        tv3 = (TextView) findViewById(R.id.textview3);


        tv1.setText("hi");

        tv2.setTextSize(20);
        tv2.setText("투명 드래곤이 울부짖었다!!!투명 드래곤이 울부짖었다!!!투명 드래곤이 울부짖었다!!!투명 드래곤이 울부짖었다!!!투명 드래곤이 울부짖었다!!!투명 드래곤이 울부짖었다!!!투명 드래곤이 울부짖었다!!!");
        tv2.setSingleLine(true);

        tv3.setTypeface(Typeface.SANS_SERIF);


        Button button1 = (Button) findViewById(R.id.go);
        Button button2 = (Button) findViewById(R.id.gocalc);
        Button button3 = (Button) findViewById(R.id.gobutton);
        Button button4 = (Button) findViewById(R.id.goToast);
        TextView text1 = (TextView) findViewById(R.id.countInt);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                int num = Integer.parseInt((String) text1.getText());
                num++;
                text1.setText(Integer.toString(num));
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
            Intent intent = new Intent(MainActivity.this, calc.class);
            startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, checkbox.class);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, PracToast.class);
                startActivity(intent);
            }
        });
    }
}
