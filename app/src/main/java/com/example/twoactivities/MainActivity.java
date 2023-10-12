package com.example.twoactivities;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Esta constante utiliza el nombre de la clase misma como etiqueta
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    // Constante publica para definir la llave para el Intent extra
    public static final String MENSAJE_EXTRA = "com.example.android.twoactivities.extra.MESSAGE";

    private EditText mMessageEditText;

    public static final int TEXT_REQUEST = 1;

    private TextView mReplyHeadTextView;

    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessageEditText = findViewById(R.id.editText_main);

        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);

        Log.d(LOG_TAG, "----------");
        Log.d(LOG_TAG, "onCreate");
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


    public void activarSegundaActividad(View view) {
        Log.d(LOG_TAG, "Botón clicado");

        // El Intent recibe dos argumentos (la aplicación y el componente que recibe el Intent)
        Intent intent = new Intent(this, SecondActivity.class);

        // Convertimos el mensaje de mMessageEditText en String
        String mensaje = mMessageEditText.getText().toString();

        // Añadimos el String como un extra en el Intent con la constante MENSAJE_EXTRA
        intent.putExtra(MENSAJE_EXTRA, mensaje);

        startActivityForResult(intent, TEXT_REQUEST);
    }

    // Este método contiene toda la información necesaria para la devolución de datos
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.RESPUESTA_EXTRA);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}