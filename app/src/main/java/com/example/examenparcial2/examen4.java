package com.example.examenparcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class examen4 extends AppCompatActivity {
    Button Finalizar;
    TextView informacion;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen4);
        Finalizar = (Button)findViewById(R.id.Finalizar);
        informacion= (TextView)findViewById(R.id.datos);
        leercredenciales();


        Finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                Toast.makeText(getApplicationContext(), "Gracias por utilizar la app de vitoLuigini su pedido fue recibido en breve se enviará", Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });

    }

    private void leercredenciales() {
        preferences=getSharedPreferences( "credenciales", Context.MODE_PRIVATE);
        informacion.setText("Estimado: " +preferences.getString("user", "")+" has seleccionado la pizza: " +preferences.getString( "pedido1"," ")+" acompañada de la bebida: " +preferences.getString( "pedido2"," ")+" debera pagar por su pizza: " +preferences.getString( "total"," ")+" y por su bebida: " +preferences.getString( "total2"," "));
    }
}