package com.example.prac4actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText texto;
    Button enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.txtMensaje);
        enviar= findViewById(R.id.btnEnviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarmensaje();
            }
        });

    }
    void enviarmensaje(){
        String ca= texto.getText().toString();
        Intent i = new Intent(MainActivity.this, Ventana2.class);
        i.putExtra("mensaje",ca);
        i.putExtra("numero",10);
        startActivity(i);

    }
}