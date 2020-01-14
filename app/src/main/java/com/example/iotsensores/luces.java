package com.example.iotsensores;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;

public class luces extends AppCompatActivity {
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luces);
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if(sensor==null)
        {
            finish();
        }
        //ImageView imagen = findViewById(R.id.imageView);
        //imagen.setImageResource(R.drawable.samir);

        sensorEventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if(event.values[0]<sensor.getMaximumRange()){
                    getWindow().getDecorView().setBackgroundColor(Color.BLACK);
                    ImageView imagen= findViewById(R.id.imageView);
                    imagen.setImageResource(R.mipmap.ic_launcher);
                }else {
                    getWindow().getDecorView().setBackgroundColor(Color.WHITE);
                    ImageView imagen= findViewById(R.id.imageView);
                    imagen.setImageResource(R.mipmap.ic_launcher_round);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        iniciar();
    }
    public void iniciar(){
        sensorManager.registerListener(sensorEventListener,sensor,2000*1000);

    }
    public void finalizar(){
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finalizar();
    }

    @Override
    protected void onResume() {
        iniciar();
        super.onResume();
    }


}
