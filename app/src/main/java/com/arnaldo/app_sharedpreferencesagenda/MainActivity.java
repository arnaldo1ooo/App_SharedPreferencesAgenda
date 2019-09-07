package com.arnaldo.app_sharedpreferencesagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre, ml_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Relacion
        et_nombre = (EditText) findViewById(R.id.et_nombre);
        ml_datos = (EditText) findViewById(R.id.ml_datos);


    }

    public void Guardar(View view) {
        String nombre = et_nombre.getText().toString();
        String datos = ml_datos.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString(nombre, datos);
        obj_editor.commit();

        Toast.makeText(this, "El contacto ha sido guardado", Toast.LENGTH_SHORT).show();
    }

    public void Buscar(View view) {
        String nombre = et_nombre.getText().toString();
        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String datos = preferencias.getString(nombre, "");

        if (datos.length() == 0) {
            Toast.makeText(this, "No se encontró ningún registro", Toast.LENGTH_SHORT).show();
        } else {
            ml_datos.setText(datos);
        }
    }
}
