package com.example.chk_java;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EventActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
//        View vw = new MyView(this);
//        vw.setOnTouchListener(TouchListner);
        tv = (TextView) findViewById(R.id.evnet_textView);
        tv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    tv.setText("Touched");
                    return true;
                }
                return false;
            }
        });


        Button buttonCar = (Button) findViewById(R.id.event_button_car);
        Button buttonAir = (Button) findViewById(R.id.event_button_airplane);

//        buttonCar.setOnClickListener(mClickLister);
//        buttonAir.setOnClickListener(mClickLister);


//        setContentView(tv);
    }

    View.OnClickListener mClickLister = new View.OnClickListener() {
        public void onClick(View v){
            if(v.getId() == R.id.event_button_car){ tv.setText("자동차"); }
            else if(v.getId() == R.id.event_button_airplane) { tv.setText("비행기"); }
        }
    };
    public void mOnClick(View v){
        if(v.getId() == R.id.event_button_car){ tv.setText("자동차"); }
        else if(v.getId() == R.id.event_button_airplane) { tv.setText("비행기"); }
    }
















//    public class MyView extends View{
//        public MyView(Context context) {
//            super(context);
//        }
//        @Override
//        public boolean onTouchEvent(MotionEvent event){
//            super.onTouchEvent(event);
//
//            if(event.getAction() == MotionEvent.ACTION_DOWN){
//                Toast.makeText(EventActivity.this, "Touch Down", Toast.LENGTH_SHORT).show();
//                return true;
//            } else if (event.getAction() == MotionEvent.ACTION_UP){
//                Toast.makeText(EventActivity.this, "Touch Up", Toast.LENGTH_SHORT).show();
//                return true;
//            }
//            return false;
//        }
//    }

    // 이 방식은 인터페이스를 상속 받으므로, implements로 받게된다.
//    public class TouchListnerClass implements View.OnTouchListener {
//
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//            if(event.getAction() == MotionEvent.ACTION_DOWN){
//                Toast.makeText(EventActivity.this, "Touch Down", Toast.LENGTH_SHORT).show();
//                return true;
//            } else if (event.getAction() == MotionEvent.ACTION_UP){
//                Toast.makeText(EventActivity.this, "Touch Up", Toast.LENGTH_SHORT).show();
//                return true;
//            }
//            return false;
//        }
//    }
//    TouchListnerClass TouchListner = new TouchListnerClass();

//    public class MyView extends View implements View.OnTouchListener {
//        public MyView(Context context){
//            super(context);
//        }
//        public boolean onTouch(View v, MotionEvent event) {
//            if(event.getAction() == MotionEvent.ACTION_DOWN){
//                Toast.makeText(EventActivity.this, "Touch Down", Toast.LENGTH_SHORT).show();
//                return true;
//            } else if (event.getAction() == MotionEvent.ACTION_UP){
//                Toast.makeText(EventActivity.this, "Touch Up", Toast.LENGTH_SHORT).show();
//                return true;
//            }
//            return false;
//        }
//    }
}