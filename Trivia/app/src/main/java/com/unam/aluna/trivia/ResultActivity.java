package com.unam.aluna.trivia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by aluna on 26/06/17.
 */

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{

    TextView puntaje;
    Button continuar,salir;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        puntaje = (TextView) findViewById(R.id.puntaje);
        continuar = (Button) findViewById(R.id.continuar);
        salir = (Button) findViewById(R.id.salir);

        Bundle datos = getIntent().getExtras();

        Integer puntos = datos.getInt("Puntos");
        linearLayout = (LinearLayout)findViewById(R.id.linear);
        puntaje.setText(puntos.toString());
        continuar.setOnClickListener(this);
        salir.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.salir){
            finish();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else{
            Intent i = new Intent(ResultActivity.this,MainActivity.class);
            startActivity(i);
        }
    }
}
