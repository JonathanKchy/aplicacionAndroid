package com.example.iotsensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class magneto extends AppCompatActivity implements SensorEventListener {
    TextView x,y,z;
    Sensor sensor;
    SensorManager senM;    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magneto);


        x= (TextView) findViewById(R.id.x);
        y= (TextView) findViewById(R.id.y);
        z= (TextView) findViewById(R.id.z);
        senM= (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor= senM.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        senM.registerListener((SensorEventListener)this,sensor,SensorManager.SENSOR_STATUS_ACCURACY_HIGH);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x.setText("Valor de x:  "+event.values[0]);
        y.setText("Valor de y:  "+event.values[1]);
        z.setText("Valor de z:  "+event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
