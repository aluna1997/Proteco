package com.example.aluna.panque;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Pay extends Activity {

    public CheckBox checkBox,checkBox2,checkBox3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);


    }

    public void onCheckboxClicked(View view) {

        switch(view.getId()) {

            case R.id.checkBox:

                checkBox2.setChecked(false);
                checkBox3.setChecked(false);

                break;

            case R.id.checkBox2:

                checkBox3.setChecked(false);
                checkBox.setChecked(false);

                break;

            case R.id.checkBox3:

                checkBox.setChecked(false);
                checkBox2.setChecked(false);

                break;

        }
    }

    public void sigue (View view) {
        if (checkBox.isChecked()) {
            Intent i = new Intent(Pay.this,Tarjeta.class);
            startActivity(i);

        }else if (checkBox2.isChecked()){
            Intent i = new Intent(Pay.this,Gracias.class);
            startActivity(i);
        }else if (checkBox3.isChecked()){
            Intent intent_sitio = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.paypal.com/mx/home"));
            startActivity(intent_sitio);

        }else {
            Toast.makeText(this, "Selecciona al menos uno", Toast.LENGTH_SHORT).show();
        }
    }

    public void atras(View view){
        Intent i = new Intent(this,Size.class);
        startActivity(i);
    }



}

