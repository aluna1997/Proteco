package com.example.aluna.panque;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by aluna on 23/06/17.
 */

public class Tarjeta extends AppCompatActivity {

    EditText numTarjeta;
    EditText codSegridad;
    boolean correcto = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjeta);

        numTarjeta = (EditText) findViewById(R.id.numTarjeta);
        codSegridad = (EditText) findViewById(R.id.codSeguridad);
       // pagar = (Button) findViewById(R.id.pagar);

    }


    public void sigue (View view){

        String tarjeta = numTarjeta.getText().toString();
        String codigo = codSegridad.getText().toString();


        if (TextUtils.isEmpty(tarjeta) || tarjeta.length() < 16) {
            Toast.makeText(this, "Numero de tarjeta invalido", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(codigo) || codigo.length() < 3) {
            Toast.makeText(this, "Numero de seguridad invalido", Toast.LENGTH_SHORT).show();
        }else {

            Intent i = new Intent(Tarjeta.this, Gracias.class);
            startActivity(i);
        }
    }
}