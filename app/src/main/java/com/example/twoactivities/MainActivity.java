package com.example.twoactivities;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Esta constante utiliza el nombre de la clase misma como etiqueta
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    // Constante publica para definir la llave para el Intent extra
    public static final String MENSAJE_EXTRA = "com.example.android.twoactivities.extra.MESSAGE";

    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessageEditText = findViewById(R.id.editText_main);
    }



    public void activarSegundaActividad(View view) {
        Log.d(LOG_TAG, "Botón clicado");

        // El Intent recibe dos argumentos (la aplicación y el componente que recibe el Intent)
        Intent intent = new Intent(this, SecondActivity.class);

        // Convertimos el mensaje de mMessageEditText en String
        String mensaje = mMessageEditText.getText().toString();

        // Añadimos el String como un extra en el Intent con la constante MENSAJE_EXTRA
        intent.putExtra(MENSAJE_EXTRA, mensaje);

        startActivity(intent);
    }
}