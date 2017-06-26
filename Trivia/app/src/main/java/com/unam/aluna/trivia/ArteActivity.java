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
 * Created by aluna on 25/06/17.
 */

public class ArteActivity extends AppCompatActivity implements View.OnClickListener{

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
        asignaPregunta(R.string.pregunta_1,R.string.respuesta_1_a,R.string.respuesta_1_b,R.string.respuesta_1_c);
        numPregunta++;
        siguiente.setOnClickListener(this);





    }

    public void asignaPregunta(Integer numPregunta, Integer Res_a, Integer Res_b, Integer Res_c){

        enunciado.setText(numPregunta);
        a.setText(Res_a);
        b.setText(Res_b);
        c.setText(Res_c);

    }

    public void calfRespuesta(CheckBox checkbox, int sigPreg) {

        if (checkbox.isChecked()) {
            Toast.makeText(ArteActivity.this, "Correcto :)", Toast.LENGTH_SHORT).show();
            puntos += 1;
        } else {
            Toast.makeText(ArteActivity.this, "Incorrecto :(", Toast.LENGTH_SHORT).show();
        }
        deseleccionarTodos();
        switch (sigPreg){
            case 2:
                asignaPregunta(R.string.pregunta_2,R.string.respuesta_2_a,R.string.respuesta_2_b,R.string.respuesta_2_c);
                numPregunta++;
                break;
            case 3:
                asignaPregunta(R.string.pregunta_3,R.string.respuesta_3_a,R.string.respuesta_3_b,R.string.respuesta_3_c);
                numPregunta++;
                break;
            case 4:
                asignaPregunta(R.string.pregunta_4,R.string.respuesta_4_a,R.string.respuesta_4_b,R.string.respuesta_4_c);
                numPregunta++;
                break;
            default:
                Intent i = new Intent(ArteActivity.this,ResultActivity.class);
                i.putExtra("Puntos",puntos);
                startActivity(i);


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

    @Override
    public void onClick(View view) {

        calfRespuesta(a,numPregunta);

    }
}