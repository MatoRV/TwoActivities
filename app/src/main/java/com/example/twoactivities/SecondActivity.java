package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Llama a Intent para activar esta actividad
        Intent intent = getIntent();

        // Llama al String que contiene la constante MainActivity.EXTRA_MESSAGE
        String mensaje = intent.getStringExtra(MainActivity.MENSAJE_EXTRA);

        // Llama al TextView por el id
        TextView tvTextMessage = findViewById(R.id.text_message);

        // Introduce el texto del TextView
        tvTextMessage.setText(mensaje);
    }
}