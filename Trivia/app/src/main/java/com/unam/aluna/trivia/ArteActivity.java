package com.unam.aluna.trivia;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;



/**
 * Created by aluna on 25/06/17.
 */

public class ArteActivity extends AppCompatActivity {

    Integer puntos = 0;
    Integer numPregunta = 0;
    TextView enunciado;
    CheckBox a;
    CheckBox b;
    CheckBox c;
    Button siguiente;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arte);

        enunciado = (TextView) findViewById(R.id.pregunta);
        a = (CheckBox) findViewById(R.id.checkBoxA);
        b = (CheckBox) findViewById(R.id.checkBoxB);
        c = (CheckBox) findViewById(R.id.checkBoxC);
        siguiente = (Button) findViewById(R.id.siguiente);


        enunciado.setText(R.string.pregunta_1);
        a.setText(R.string.respuesta_1_a);
        b.setText(R.string.respuesta_1_b);
        c.setText(R.string.respuesta_1_c);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (a.isChecked()) {
                    Toast.makeText(ArteActivity.this, "Correcto :)", Toast.LENGTH_SHORT).show();
                }

                numPregunta +=1;

                if (numPregunta == 1) {
                    calfRespuesta(a, R.string.pregunta_2);
                    numPregunta +=1;
                }

                if (numPregunta == 3) {
                    calfRespuesta(a, R.string.pregunta_3);
                }

                deseleccionarTodos();

            }


        });


    }


    public void calfRespuesta(CheckBox checkbox, int sigPreg) {

        if (checkbox.isChecked()) {
            Toast.makeText(ArteActivity.this, "Correcto :)", Toast.LENGTH_SHORT).show();
            puntos += 1;
            enunciado.setText(sigPreg);
        } else {
            Toast.makeText(ArteActivity.this, "Incorrecto :(", Toast.LENGTH_SHORT).show();
            enunciado.setText(sigPreg);
        }


    }


    public void soloUnaRespuesta(View view) {

        switch(view.getId()) {

            case R.id.checkBoxA:

                b.setChecked(false);
                c.setChecked(false);

                break;

            case R.id.checkBoxB:

                c.setChecked(false);
                a.setChecked(false);

                break;

            case R.id.checkBoxC:

                a.setChecked(false);
                b.setChecked(false);

                break;

        }
    }

    public void deseleccionarTodos (){
        a.setChecked(false);
        b.setChecked(false);
        c.setChecked(false);
    }

}