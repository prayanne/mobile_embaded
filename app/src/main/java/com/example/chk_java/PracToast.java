package com.example.chk_java;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracToast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practoast);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final Button button1 = (Button) findViewById(R.id.ToastBtn);
        final Button button2 = (Button) findViewById(R.id.alertBtn);
        final Button button3 = (Button) findViewById(R.id.adaptDialog);
        TextView DMsg = (TextView) findViewById(R.id.DMsg);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast tMsg = Toast.makeText(PracToast.this, "HI I'm tMsg", Toast.LENGTH_SHORT);
                Toast.makeText(PracToast.this, "HI I'm just show", Toast.LENGTH_LONG).show();
                tMsg.show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String[] arrData = new String[] {"checkbox1", "checkbox2", "checkbox3"};
                final boolean[] arrCheck = new boolean[] {false, false, true};
                AlertDialog.Builder dlg = new AlertDialog.Builder(PracToast.this);
                dlg.setTitle("Choose chk");
//                dlg.setMessage("this is message");


                dlg.setIcon(R.mipmap.ic_launcher);
//                dlg.setPositiveButton("Check", null);
                dlg.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DMsg.setText("connect Check");
                    }
                });

                dlg.setMultiChoiceItems(arrData, arrCheck, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        button2.setText(arrData[which]);
                    }
                });

                dlg.show();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView nameSpace = (TextView) findViewById(R.id.nameSpace);
                TextView emailSpace = (TextView) findViewById(R.id.emailSpace);

                TextView output = (TextView) findViewById(R.id.toastText1);

                View dialogView = (View) View.inflate(PracToast.this, R.layout.dialog1, null);

                AlertDialog.Builder dlg = new AlertDialog.Builder(PracToast.this);

                dlg.setTitle("Input User Data");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                dlg.setView(dialogView);
                dlg.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText text1 = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                        EditText text2 = (EditText) dialogView.findViewById(R.id.dlgEdt2);
                        nameSpace.setText(text1.getText().toString());
                        emailSpace.setText(text2.getText().toString());
                    }
                });
                dlg.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = new Toast(PracToast.this);
                        View toastView = (View) View.inflate(PracToast.this, R.layout.toast, null);
                        TextView toastText = (TextView) toastView.findViewById(R.id.toastText1);

                        toast.setView(toastView);
                        toastText.setText("cancled");
                        toast.show();

                    }
                });
                dlg.show();
            }
        });
    }
}