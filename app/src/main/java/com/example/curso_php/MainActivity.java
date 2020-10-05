package com.example.curso_php;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //BOTON siguiente


        }
    public void Siguiente(View view){
        Intent siguiente = new Intent(this,Curso.class);
        startActivity(siguiente);
        finish();

    }

    public void Acerca(View view){
        Intent acerca = new Intent(this,acerca_de.class);
        startActivity(acerca);
        finish();

    }
}