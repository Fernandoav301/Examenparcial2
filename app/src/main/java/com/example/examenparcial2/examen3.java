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

import java.util.prefs.Preferences;

public class examen3 extends AppCompatActivity {

    Button final1, bebidas;
    ImageView pregunta1, pregunta2, pregunta3;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen3);
        final1 = (Button) findViewById(R.id.finalizar1);
        bebidas = (Button) findViewById(R.id.bebidas);
        pregunta1 = (ImageView) findViewById(R.id.pregunta1);
        pregunta2 = (ImageView) findViewById(R.id.pregunta2);
        pregunta3 = (ImageView) findViewById(R.id.pregunta3);

        pregunta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuardarCredenciales("Mexicana");
                GuardarCredenciales2("$130.00 pesos");




            }
        });

        pregunta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuardarCredenciales("Hawaina");
                GuardarCredenciales2("$95.00 pesos");


            }
        });

        pregunta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuardarCredenciales("Peperoni");
                GuardarCredenciales2("$115.00 pesos");


            }
        });

        final1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), examen4.class);
                startActivity(i);

            }
        });

        bebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), pantallafinal.class);
                startActivity(i);
            }
        });
    }

    private void GuardarCredenciales(String boton1) {
        preferences= getSharedPreferences( "credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("pedido1", boton1);
        editor.commit();

    }



    private void GuardarCredenciales2(String total) {
        preferences= getSharedPreferences( "credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("total", total);
        editor.commit();

    }

}