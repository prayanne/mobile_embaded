package com.example.chk_java;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calc extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnMin, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        btnAdd = (Button) findViewById(R.id.calcp);
        btnMin = (Button) findViewById(R.id.calcm);
        btnMul = (Button) findViewById(R.id.calcx);
        btnDiv = (Button) findViewById(R.id.calcd);
        textResult = (TextView) findViewById(R.id.output);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) + Integer.parseInt(num2);

                textResult.setText("계산 결과: " + result.toString());
            }
        });
        btnMin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) - Integer.parseInt(num2);

                textResult.setText("계산 결과: " + result.toString());
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) * Integer.parseInt(num2);

                textResult.setText("계산 결과: " + result.toString());
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if (Integer.parseInt(num2) == 0) {
                    textResult.setText("계산 결과: 0으로 나눌 수 없습니다.");
                } else {
                    result = Integer.parseInt(num1) / Integer.parseInt(num2);
                    textResult.setText("계산 결과: " + result.toString());
                }
            }
        });
    }
}