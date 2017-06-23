package com.example.aluna.panque;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * Created by aluna on 21/06/17.
 */

public class Conservas extends Activity {

    CheckBox checkBoxUno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conservas);


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
