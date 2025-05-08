package com.example.chk0508_sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.chk0508_sensor.databinding.ActivitySensorBinding;

import java.util.List;

public class SensorActivity extends AppCompatActivity {
    ActivitySensorBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySensorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        String sensorInfo = "";
        for (Sensor s: sensorList){
            sensorInfo = sensorInfo + s.getName() + "\n";
        }

        binding.sensorView.setText(sensorInfo);

    }
}