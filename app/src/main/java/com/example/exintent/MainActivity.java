package com.example.exintent;

import static android.app.Activity.RESULT_OK;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button1 = (Button) findViewById(R.id.btnCall);
        Button button2 = (Button) findViewById(R.id.btnWeb);
        Button button3 = (Button) findViewById(R.id.btnMap);
        Button button4 = (Button) findViewById(R.id.btnSearch);
        Button button5 = (Button) findViewById(R.id.btnSms);
        Button button6 = (Button) findViewById(R.id.btnPhoto);
        Button button7 = (Button) findViewById(R.id.btnCalc);
        Button button8 = (Button) findViewById(R.id.btnScoll);
        Button button9 = (Button) findViewById(R.id.btnViewF);
        Button button10 = (Button) findViewById(R.id.btnAction);



        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri uri = Uri.parse("tel:01012341234");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri uri = Uri.parse("https://www.tukorea.ac.kr");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri uri = Uri.parse("https://maps.google.co.kr/maps?q=" + 37.559133 + "," + 126.927824);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "안드로이드");
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "hi?");
                intent.setData(Uri.parse("smsto:" + Uri.encode("010-1234-1234")));
                startActivity(intent);
            }
        });
        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });
        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText edt1  = (EditText)findViewById(R.id.edt1num);
                EditText edt2  = (EditText)findViewById(R.id.edt2num);
                Intent intent = new Intent(getApplicationContext(), CalcActivity.class);
                intent.putExtra("num1", Integer.parseInt(edt1.getText().toString()));
                intent.putExtra("num2", Integer.parseInt(edt2.getText().toString()));
                startActivityForResult(intent, 0);
            }
        });
        button8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), ScrollActivity.class);
                startActivity(intent);
            }
        });
        button9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), ViewFlipperActivity.class);
                startActivity(intent);
            }
        });
        button9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), ActionBarActivity.class);
                startActivity(intent);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
//        super.onActivityResult();
        if(resultCode == RESULT_OK){
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "합계: " + hap, Toast.LENGTH_SHORT).show();
        }
    }
}
