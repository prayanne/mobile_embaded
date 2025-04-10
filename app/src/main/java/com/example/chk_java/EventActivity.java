package com.example.chk_java;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_event);
        View vw = new MyView(this);
        setContentView(vw);
    }

    public class MyView extends View{
        public MyView(Context context) {
            super(context);
        }
        @Override
        public boolean onTouchEvent(MotionEvent event){
            super.onTouchEvent(event);

            if(event.getAction() == MotionEvent.ACTION_DOWN){
                Toast.makeText(EventActivity.this, "Touch Down", Toast.LENGTH_SHORT).show();
                return true;
            } else if (event.getAction() == MotionEvent.ACTION_UP){
                Toast.makeText(EventActivity.this, "Touch Up", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }
    }
}