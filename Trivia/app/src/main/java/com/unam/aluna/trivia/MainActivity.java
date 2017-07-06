package com.unam.aluna.trivia;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button arteBtn;
    public Button cineBtn;
    public Button deportesBtn;
    public Button cienciaBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Bloqueaos la orientacion horizontal
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        arteBtn = (Button)findViewById(R.id.arte);
        cineBtn = (Button) findViewById(R.id.cine);
        cienciaBtn = (Button) findViewById(R.id.ciencia);
        deportesBtn = (Button) findViewById(R.id.deportes);

        arteBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ArteActivity.class);
                startActivity(i);
            }
        });

        cineBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CineActivity.class);
                startActivity(i);
            }
        });

        deportesBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DeportesActivity.class);
                startActivity(i);
            }
        });

        cienciaBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CienciaActivity.class);
                startActivity(i);
            }
        });

    }
}
