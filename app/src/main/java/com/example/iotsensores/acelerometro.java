package com.example.iotsensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class acelerometro extends AppCompatActivity implements SensorEventListener {
    TextView x,y,z;
    SensorManager senM;
    List<Sensor> sensores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);
        x= (TextView) findViewById(R.id.x);
        y= (TextView) findViewById(R.id.y);
        z= (TextView) findViewById(R.id.z);
         senM= (SensorManager)getSystemService(SENSOR_SERVICE);
         sensores= senM.getSensorList(Sensor.TYPE_ACCELEROMETER);
         if(sensores.size()>0)
         {
             senM.registerListener((SensorEventListener)this,sensores.get(0),SensorManager.SENSOR_STATUS_ACCURACY_HIGH);
         }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x.setText("Valor de x:  "+event.values[SensorManager.DATA_X]);
        y.setText("Valor de y:  "+event.values[SensorManager.DATA_Y]);
        z.setText("Valor de z:  "+event.values[SensorManager.DATA_Z]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
