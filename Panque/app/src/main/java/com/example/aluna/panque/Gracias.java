package com.example.aluna.panque;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by aluna on 23/06/17.
 */

public class Gracias extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gracias);
    }

    @Override
    public void onBackPressed() {
        //El usuario no puede regresar
    }
}
