package com.example.curso_php;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Curso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);
    }

    public void bas(View view){
        Intent bas = new Intent(this,contenido_basico.class);
        startActivity(bas);
        finish();

    }
    public void intermedio(View view){
        Intent intermedio = new Intent(this,contenido_intermedio.class);
        startActivity(intermedio);
        finish();

    }

    public void avan(View view){
        Intent avan = new Intent(this,contenido_avanzado.class);
        startActivity(avan);
        finish();

    }

    public void Anterior(View view) {
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
        finish();
    }


    public void logo(View view) {
        Intent logo= new Intent(this, MainActivity.class);
        startActivity(logo);
        finish();
    }
}