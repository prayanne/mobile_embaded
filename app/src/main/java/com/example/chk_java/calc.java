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
                Double result = cac.plus(num1, num2);
                textResult.setText("계산 결과: " + result.toString());
            }
        });
        btnMin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                Double result = cac.minus(num1, num2);
                textResult.setText("계산 결과: " + result.toString());
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                Double result = cac.multiple(num1, num2);
                textResult.setText("계산 결과: " + result.toString());
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                Double result = cac.divine(num1, num2);
                textResult.setText("계산 결과: " + result.toString());
            }
        });
    }

    private static class cac {
        public static double[] str2dou(String n1, String n2){
            double[] result = new double[2];
            result[0] = Double.parseDouble(n1);
            result[1] = Double.parseDouble(n2);
            return result;
        }
        public static double plus(String n1, String n2){
            double[] data = new double[2];
            data = str2dou(n1, n2);
            return data[0] + data[1];
        }
        public static double minus(String n1, String n2){
            double[] data = new double[2];
            data = str2dou(n1, n2);
            return data[0] - data[1];
        }
        public static double multiple(String n1, String n2){
            double[] data = new double[2];
            data = str2dou(n1, n2);
            return data[0] * data[1];
        }
        public static double divine(String n1, String n2){
            double[] data = new double[2];
            data = str2dou(n1, n2);
            if (data[1] == 0){
                return 0;
            } else {
                return data[0] / data[1];
            }
        }
    }
}