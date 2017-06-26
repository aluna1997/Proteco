package com.unam.aluna.trivia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by aluna on 25/06/17.
 */

public class CorrectActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correcto);

       /* new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(CorrectActivity.this,.class);
                startActivity(i);
                finish();
            }
        },1000);
    }
    **/
    }
}
