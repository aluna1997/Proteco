package com.example.aluna.panque;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Size extends Activity {

    public CheckBox checkBox,checkBox2,checkBox3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size);

        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
    }

    public void sigue(View view){
        if (selectOne() == true) {
        Intent i = new Intent(this,Pay.class);
        startActivity(i);
        }else {
            Toast.makeText(this, "Selecciona almenos uno", Toast.LENGTH_SHORT).show();
        }
    }

    public void atras(View view){
        Intent i = new Intent(this,Postre.class);
        startActivity(i);
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

    public boolean selectOne (){
        if(!(checkBox.isChecked() | checkBox2.isChecked() | checkBox3.isChecked())){
            return false;
        }else {
            return true;
        }
    }
}
