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
    String user, pedido1 ,pedido2, total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen4);
        Finalizar = (Button) findViewById(R.id.Finalizar);
        informacion = (TextView) findViewById(R.id.datos);
        leercredenciales();
        calculadorTotal();
        if (pedido1.equals(""))
            pedido1 = "Ninguna";
        if (pedido2.equals(""))
            pedido2 = "Ninguna";
        informacion.setText("Estimado: " + user + " has seleccionado la pizza: " + pedido1 + " acompañada de la bebida: " + pedido2 + " Y su total a pagar es: " + total);
        Finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (total.equals("0")) {
                    Toast.makeText(getApplicationContext(), "Debe seleccionar al menos una bebida o una pizza", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Gracias por utilizar la app de vitoLuigini su pedido fue recibido en breve se enviará", Toast.LENGTH_LONG).show();
                    ReiniciarDatos();
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }

            }

        });

    }
         private void ReiniciarDatos() {
        preferences=getSharedPreferences( "credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("pedido1", "");
        editor.putString("pedido2", "");
        editor.putString("total", "");
        editor.commit();


    }

    private void calculadorTotal() {
        if(!pedido1.equals("")&&!pedido2.equals(""))
            total="120";
        if(!pedido1.equals("")&&pedido2.equals(""))
            total="100";
        if(pedido1.equals("")&&!pedido2.equals(""))
            total="20";
        if(pedido1.equals("")&&pedido2.equals(""))
            total="0";
    }

    private void leercredenciales() {
        preferences=getSharedPreferences( "credenciales", Context.MODE_PRIVATE);
        user=preferences.getString("user","");
        pedido1=preferences.getString("pedido1", "");
        pedido2=preferences.getString("pedido2"," ");

    }
}