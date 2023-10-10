package com.example.twoactivities;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Esta constante utiliza el nombre de la clase misma como etiqueta
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void activarSegundaActividad(View view) {
        Log.d(LOG_TAG, "Botón clicado");

        // El Intent recibe dos argumentos (la aplicación y el componente que recibe el Intent)
        Intent intent = new Intent(this, SecondActivity.class);

        startActivity(intent);
    }
}