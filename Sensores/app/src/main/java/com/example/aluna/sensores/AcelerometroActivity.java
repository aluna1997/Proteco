package com.example.aluna.sensores;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aluna on 20/06/17.
 */

public class AcelerometroActivity extends AppCompatActivity implements SensorEventListener{

    TextView x,y,z;
    Sensor mAcelerometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acelerometro);
        x = (TextView)findViewById(R.id.ejeX);
        y = (TextView) findViewById(R.id.ejeY);
        z = (TextView) findViewById(R.id.ejeZ);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    protected void onResume(){
        super.onResume();
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (sensors.size() > 0) {
            sensorManager.registerListener(this,sensors.get(0),sensorManager.SENSOR_DELAY_GAME);
        }
    }

    protected void onPause(){
        super.onPause();
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.unregisterListener(this,mAcelerometro);
    }

    protected void onStop(){
        super.onStop();
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.unregisterListener(this,mAcelerometro);
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        this.x.setText("Eje x = " + sensorEvent.values[SensorManager.DATA_X]);
        this.y.setText("Eje y = " + sensorEvent.values[SensorManager.DATA_Y]);
        this.z.setText("Eje z = " + sensorEvent.values[SensorManager.DATA_Z]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
