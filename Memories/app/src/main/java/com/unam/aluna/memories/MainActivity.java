package com.unam.aluna.memories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {

    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private String nombreUsuario;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        loginButton = (LoginButton) findViewById(R.id.login_button);
        // Creando un callbackManager toda a la info d lo que pasa con nuestra app
        callbackManager = CallbackManager.Factory.create();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                obtenerDatos(loginResult);
                //compartir();
                Toast.makeText(MainActivity.this, "Hola," + nombreUsuario, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, WonderPlacesActiviy.class);
                startActivity(i);
            }

            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this, "Se cancelo la operacion", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(MainActivity.this, "Culpa de Facebook", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // El callbackManager de Fb ya nos da todos los datos
        callbackManager.onActivityResult(requestCode, resultCode, data);

    }

    private void obtenerDatos(LoginResult loginResult) {
        GraphRequest solicitud = GraphRequest
                .newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Toast.makeText(MainActivity.this, "Se obtuvieron los datos", Toast.LENGTH_SHORT).show();
                    }
                });

        Bundle parametros = new Bundle();
        parametros.putString("fields", "name");
        solicitud.setParameters(parametros);

        try {
            nombreUsuario = (String) solicitud.executeAsync().get().get(0).getJSONObject().get("name");
        } catch (InterruptedException Inte) {
            Toast.makeText(this, "Ocurrio un error", Toast.LENGTH_SHORT).show();
        } catch (ExecutionException Exce) {
            Toast.makeText(this, "Ocurrio un error", Toast.LENGTH_SHORT).show();
        } catch (JSONException Jsone) {
            Toast.makeText(this, "No se pudieron traer los datos", Toast.LENGTH_SHORT).show();
        }


    }

}
