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
    TextView nombre;
    String user;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen2);
        anterior = (Button) findViewById(R.id.anterior);
        rebanada = (ImageView) findViewById(R.id.rebanada);
        refresco = (ImageView) findViewById(R.id.refresco);
        nombre = (TextView) findViewById(R.id.nombre);
        LeerCredenciales();
        nombre.setText("Hola estimado: " +user+ "¿qué te podemos llevar hasta tu casa este día? Por favor selecciona:");

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

    private void LeerCredenciales() {
        preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        user = preferences.getString("user","");
    }


}