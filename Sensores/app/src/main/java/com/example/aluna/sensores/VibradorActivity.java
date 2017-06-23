package com.example.aluna.sensores;

import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by aluna on 20/06/17.
 */

public class VibradorActivity extends AppCompatActivity {

    Button unaVez,repetidas,stop;
    boolean estaVibrando = false;
    Vibrator vibrador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vibrador);
        unaVez = (Button) findViewById(R.id.vibrarUna);
        repetidas = (Button) findViewById(R.id.vibrarRepetidas);
        stop = (Button) findViewById(R.id.stop);
        vibrador = ((Vibrator) getSystemService(VIBRATOR_SERVICE));
        vibrador.cancel();
    }

    public void vibrarUnaVez(View view){
        if (!vibrador.hasVibrator()) {
            Toast.makeText(this, "No tienes vibrador", Toast.LENGTH_SHORT).show();
            return;
        }
        if(estaVibrando)
            vibrador.cancel();
        vibrador.vibrate(1000);
        estaVibrando = true;
        stop.setEnabled(true);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                estaVibrando = false;
                stop.setEnabled(false);
            }
        },100);

    }


    public void vibrarRespetidas (View view){
        if (!vibrador.hasVibrator()) {
            Toast.makeText(this, "No tienes vibrador", Toast.LENGTH_SHORT).show();
        }

        if (estaVibrando)
            vibrador.cancel();
        long delay = 250;
        long sigueVib = 250;
        long on_off = 250;
        int repeat = 1;

        vibrador.vibrate(new long[]{delay,sigueVib,on_off,on_off,on_off},repeat);
        estaVibrando = true;
        stop.setEnabled(true);
        }

    public void detener(View view){
        if (!vibrador.hasVibrator()) {
            Toast.makeText(this, "No tienes vibrador", Toast.LENGTH_SHORT).show();
        }
        if(estaVibrando){
            vibrador.cancel();
            stop.setEnabled(false);
            estaVibrando = false;
        }
    }
    }

