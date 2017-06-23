package com.example.aluna.panque;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class Postre extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postre);
    }

    public void sigue(View view){
        Intent i = new Intent(this,Size.class);
        startActivity(i);
    }

    public void atras(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

}
