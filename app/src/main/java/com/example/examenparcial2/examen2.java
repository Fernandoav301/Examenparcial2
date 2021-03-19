package com.example.examenparcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class examen2 extends AppCompatActivity {
    Button anterior;
    ImageView refresco, rebanada;
    TextView nombreuser;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen2);
        anterior = (Button) findViewById(R.id.anterior);
        rebanada = (ImageView) findViewById(R.id.rebanada);
        refresco = (ImageView) findViewById(R.id.refresco);
        nombreuser = (TextView) findViewById(R.id.nombre);
        leercredenciales();
        refresco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), pantallafinal.class);
                startActivity(i);

            }
        });

        rebanada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), examen3.class);
                startActivity(i);
            }
        });

        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void leercredenciales() {
        preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        nombreuser.setText("Hola estimado: " + preferences.getString("user", "") + "¿qué te podemos llevar hasta tu casa este día? Por favor selecciona:");
    }


}