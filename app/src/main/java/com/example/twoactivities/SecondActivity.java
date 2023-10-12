package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String RESPUESTA_EXTRA = "com.example.android.twoactivities.extra.REPLY";

    private static final String LOG_TAG = SecondActivity.class.getSimpleName();

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

    @Override
    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    public void returnReply(View view) {
        EditText mRespuesta = findViewById(R.id.editText_second);

        String reply = mRespuesta.getText().toString();

        Intent replyIntent = new Intent();

        replyIntent.putExtra(RESPUESTA_EXTRA, reply);

        // Poniendo como resultado RESULT_OK indica que la respuesta fue un éxito.
        setResult(RESULT_OK, replyIntent);

        // Llamando a finish cierra la actividad y vuelve a MainActivity.
        finish();

        Log.d(LOG_TAG, "Final SecondActivity");
    }
}