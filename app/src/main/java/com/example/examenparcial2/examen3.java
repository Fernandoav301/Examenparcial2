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

public class examen3 extends AppCompatActivity {

    Button continuar, regresar;
    ImageView pregunta1, pregunta2, pregunta3;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen3);
        continuar = (Button) findViewById(R.id.Continuar);
        regresar = (Button) findViewById(R.id.regresar);
        pregunta1= (ImageView) findViewById(R.id.pregunta1);
        pregunta2= (ImageView) findViewById(R.id.pregunta2);
        pregunta3= (ImageView) findViewById(R.id.pregunta3);

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), examen4.class);
                startActivity(i);
                GuardarCredenciales(pregunta1.getText().toString(),pregunta2.getText().toString(),pregunta3.getText().toString());
                startActivity(i);
            }
        });

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), examen2.class);
                startActivity(i);
            }
        });
    }

    private void GuardarCredenciales(String p1, String p2, String p3) {
        preferences= getSharedPreferences( "credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("pregunta1", p1);
        editor.putString("pregunta2", p2);
        editor.putString("pregunta3", p3);
        editor.commit();

    }

}
