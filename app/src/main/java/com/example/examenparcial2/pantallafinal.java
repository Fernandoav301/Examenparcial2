package com.example.examenparcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class pantallafinal extends AppCompatActivity {
    Button final2, pizzas;
    ImageView pregunta4, pregunta5, pregunta6;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallafinal);
        final2 = (Button) findViewById(R.id.finalizar2);
        pizzas = (Button) findViewById(R.id.pizzas);
        pregunta4 = (ImageView) findViewById(R.id.pregunta4);
        pregunta5 = (ImageView) findViewById(R.id.pregunta5);
        pregunta6 = (ImageView) findViewById(R.id.pregunta6);

        pregunta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuardarCredenciales("Coca cola");


            }
        });

        pregunta5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuardarCredenciales("Fanta");


            }
        });

        pregunta6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuardarCredenciales("Pepsi");


            }
        });

        final2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), examen4.class);
                startActivity(i);

            }
        });

        pizzas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), examen3.class);
                startActivity(i);
            }
        });
    }


    private void GuardarCredenciales(String boton2) {
        preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("pedido2", boton2);
        editor.commit();

    }

}

