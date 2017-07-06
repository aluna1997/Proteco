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

public class CineActivity extends AppCompatActivity implements View.OnClickListener {

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
        setContentView(R.layout.activity_preguntaeincisos);

        enunciado = (TextView) findViewById(R.id.pregunta);
        a = (CheckBox) findViewById(R.id.checkBoxA);
        b = (CheckBox) findViewById(R.id.checkBoxB);
        c = (CheckBox) findViewById(R.id.checkBoxC);
        siguiente = (Button) findViewById(R.id.siguiente);
        asignaPregunta(R.string.pregunta_1_2, R.string.respuesta_1_2_a, R.string.respuesta_1_2_b, R.string.respuesta_1_2_c);
        numPregunta++;
        siguiente.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (numPregunta) {
            case 2:
                calfRespuesta(b, numPregunta);
                break;
            case 3:
                calfRespuesta(b, numPregunta);
                break;
            case 4:
                calfRespuesta(c, numPregunta);
                break;
            case 5:
                calfRespuesta(b, numPregunta);
                break;
            default:
                break;
        }
    }

    public void calfRespuesta(CheckBox checkbox, int sigPreg) {

        if (checkbox.isChecked()) {
            Toast.makeText(CineActivity.this, "Correcto :)", Toast.LENGTH_SHORT).show();
            puntos += 1;
        } else {
            Toast.makeText(CineActivity.this, "Incorrecto :(", Toast.LENGTH_SHORT).show();
        }
        deseleccionarTodos();
        switch (sigPreg) {
            case 2:
                asignaPregunta(R.string.pregunta_2_2, R.string.respuesta_2_2_a, R.string.respuesta_2_2_b, R.string.respuesta_2_2_c);
                numPregunta++;
                break;
            case 3:
                asignaPregunta(R.string.pregunta_3_2, R.string.respuesta_3_2_a, R.string.respuesta_3_2_b, R.string.respuesta_3_2_c);
                numPregunta++;
                break;
            case 4:
                asignaPregunta(R.string.pregunta_4_2, R.string.respuesta_4_2_a, R.string.respuesta_4_2_b, R.string.respuesta_4_2_c);
                numPregunta++;
                break;
            default:
                Intent i = new Intent(CineActivity.this, ResultActivity.class);
                i.putExtra("Puntos", puntos);
                startActivity(i);
        }


    }


    public void asignaPregunta(Integer numPregunta, Integer Res_a, Integer Res_b, Integer Res_c) {

        enunciado.setText(numPregunta);
        a.setText(Res_a);
        b.setText(Res_b);
        c.setText(Res_c);

    }

    public void deseleccionarTodos() {
        a.setChecked(false);
        b.setChecked(false);
        c.setChecked(false);
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
}
