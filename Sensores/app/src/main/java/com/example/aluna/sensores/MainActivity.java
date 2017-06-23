package com.example.aluna.sensores;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView salida;
    Button vibrador,giroscopio,proximidad,acelerometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibrador = (Button) findViewById(R.id.vibrador);
        giroscopio = (Button) findViewById(R.id.giroscopio);
        proximidad = (Button) findViewById(R.id.proximidad);
        acelerometro = (Button) findViewById(R.id.acelerometro);
        salida = (TextView) findViewById(R.id.salida);

        vibrador.setOnClickListener(this);
        giroscopio.setOnClickListener(this);
        proximidad.setOnClickListener(this);
        acelerometro.setOnClickListener(this);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor : listaSensores) {
            log(sensor.getName());
        }
    }

        //Convierte a cadena
        public void log (String string){
            salida.append(string + "\n");
        }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.vibrador:
                Intent i= new Intent(this,VibradorActivity.class);
                startActivity(i);
                break;
            case R.id.acelerometro:
                Intent i2 = new Intent(this,AcelerometroActivity.class);
                startActivity(i2);
                break;
            case  R.id.giroscopio:
                Intent i3 = new Intent(this,GiroscopioActivity.class);
                startActivity(i3);
                break;
            case R.id.proximidad:
                Intent i4 = new Intent(this,ProximidadActivity.class);
                startActivity(i4);
                break;

            default:
                break;

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

