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
        tv2.setText("asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdf");
        tv2.setSingleLine(true);

        tv3.setTypeface(Typeface.SANS_SERIF);

        Button button1 = (Button) findViewById(R.id.go);
        Button button2 = (Button) findViewById(R.id.gocalc);
        Button button3 = (Button) findViewById(R.id.gobutton);
        Button button4 = (Button) findViewById(R.id.goToast);
        Button button5 = (Button) findViewById(R.id.goEvnet);
        Button button6 = (Button) findViewById(R.id.goLayout);
        Button button7 = (Button) findViewById(R.id.goPoem);
        TextView text1 = (TextView) findViewById(R.id.countInt);

        Button[] buttons = {
                button1,
                button2,
                button3,
                button4,
                button5,
                button6,
                button7
        };

//        for (Button btn: buttons
//             ) {
//            btn.setOnClickListener(new View.OnClickListener() {
//
//            });
//        }
        
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
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                startActivity(intent);
            }
        });
        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, TestLayout1Activity.class);
                startActivity(intent);
            }
        });
        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
    }
}
