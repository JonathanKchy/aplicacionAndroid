package com.example.iotsensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void acelerometro (View vista){
        Intent acelera = new Intent(this,acelerometro.class);
        startActivity(acelera);
    }

    public void luz (View vista){
        Intent luces = new Intent(this, luces.class);
        startActivity(luces);
    }

    public void magnetometro (View vista){
        Intent mag = new Intent(this,magneto.class);
        startActivity(mag);
    }

    public void audio (View vista){
        Intent sonid = new Intent(this,sonido.class);
        startActivity(sonid);
    }

}
