package com.unam.aluna.trivia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by aluna on 27/06/17.
 */

public class CienciaActivity extends AppCompatActivity implements View.OnClickListener {

    Integer puntos = 0;
    Integer numPregunta = 1;
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
        asignaPregunta(R.string.pregunta_1_4, R.string.respuesta_1_4_a, R.string.respuesta_1_4_b, R.string.respuesta_1_4_c);
        numPregunta++;
        siguiente.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        switch (numPregunta) {
            case 2:
                calfRespuesta(a, numPregunta);
                break;
            case 3:
                calfRespuesta(b, numPregunta);
                break;
            case 4:
                calfRespuesta(a, numPregunta);
                break;
            case 5:
                calfRespuesta(c, numPregunta);
                break;
            default:
                calfRespuesta(c, numPregunta);
                break;
        }
    }

    public void asignaPregunta(Integer numPregunta, Integer Res_a, Integer Res_b, Integer Res_c) {

        enunciado.setText(numPregunta);
        a.setText(Res_a);
        b.setText(Res_b);
        c.setText(Res_c);

    }

    public void calfRespuesta(CheckBox checkbox, int sigPreg) {

        if (checkbox.isChecked()) {
            Toast.makeText(CienciaActivity.this, "Correcto :)", Toast.LENGTH_SHORT).show();
            puntos += 1;
        } else {
            Toast.makeText(CienciaActivity.this, "Incorrecto :(", Toast.LENGTH_SHORT).show();
        }
        deseleccionarTodos();
        switch (sigPreg) {
            case 2:
                asignaPregunta(R.string.pregunta_2_4, R.string.respuesta_2_4_a, R.string.respuesta_2_4_b, R.string.respuesta_2_4_c);
                numPregunta++;
                break;
            case 3:
                asignaPregunta(R.string.pregunta_3_4, R.string.respuesta_3_4_a, R.string.respuesta_3_4_b, R.string.respuesta_3_4_c);
                numPregunta++;
                break;
            case 4:
                asignaPregunta(R.string.pregunta_4_4, R.string.respuesta_4_4_a, R.string.respuesta_4_4_b, R.string.respuesta_4_4_c);
                numPregunta++;
                break;
            default:
                Intent i = new Intent(CienciaActivity.this, ResultActivity.class);
                i.putExtra("Puntos", puntos);
                startActivity(i);
        }


    }


    public void soloUnaRespuesta(View view) {

        switch (view.getId()) {

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

    public void deseleccionarTodos() {
        a.setChecked(false);
        b.setChecked(false);
        c.setChecked(false);
    }

}
