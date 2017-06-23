package com.example.aluna.panque;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.aluna.panque.R.id.checkBox;

public class MainActivity extends Activity {

    private TextView mTextMessage;
    Button sigue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Opcion dos de intent
        /*sigue = (Button) findViewById(R.id.btn_sigue);
        sigue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Postre.class);
            }
        });
        */


    }

    //Opcion dos definir onClick en xml y poner el nombre de este metodo
    public void postre(View view){
        Intent i = new Intent(this,Postre.class);
        startActivity(i);
    }

    public void mexicano(View view){
        Intent i = new Intent(this,Mexicano.class);
        startActivity(i);
    }

    public void conserva(View view){
        Intent i = new Intent(this,Conservas.class);
        startActivity(i);
    }
}
