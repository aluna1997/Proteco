package com.example.aluna.panque;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * Created by aluna on 21/06/17.
 */

public class Mexicano extends AppCompatActivity {

    public CheckBox checkBox,checkBox2,checkBox3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mexicano);


        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
    }

    public void sigue(View view){
        if (selectOne() == true) {
        Intent i = new Intent(this,Size.class);
        startActivity(i);
        }else {
            Toast.makeText(this, "Selecciona almenos uno", Toast.LENGTH_SHORT).show();
        }
    }

    public void atras(View view){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
    }


    public boolean selectOne (){
        if(!(checkBox.isChecked() | checkBox2.isChecked() | checkBox3.isChecked())){
            return false;
        }else {
            return true;
        }
    }

}
