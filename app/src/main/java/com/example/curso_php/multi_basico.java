package com.example.curso_php;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class multi_basico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_basico);
    }

    //--------------------------------------------------------------------------
    public void Anterior(View view) {
        Intent anterior = new Intent(this, contenido_basico.class);
        startActivity(anterior);
        finish();
    }



    //--------------------------------------------------------------------------
    public void Multib(View view) {
        Intent multib = new Intent(this, multi_basico.class);
        startActivity(multib);
        finish();
    }




    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    public void Multimedia(View view) {
        Intent multimedia = new Intent(this, multi1.class);
        startActivity(multimedia);
        finish();
    }

    //--------------------------------------------------------------------------
    public void Multimedia2(View view) {
        Intent multimedia2 = new Intent(this, multi2.class);
        startActivity(multimedia2);
        finish();
    }
    //--------------------------------------------------------------------------
    public void Multimedia3(View view) {
        Intent multimedia3 = new Intent(this, multi3.class);
        startActivity(multimedia3);
        finish();
    }

   /* //--------------------------------------------------------------------------
    public void Multimedia(View view) {
        Intent multimedia = new Intent(this, multi1.class);
        startActivity(multimedia);
        finish();
    }

    //--------------------------------------------------------------------------
    public void Multimedia(View view) {
        Intent multimedia = new Intent(this, multi1.class);
        startActivity(multimedia);
        finish();
    }

    //--------------------------------------------------------------------------
    public void Multimedia(View view) {
        Intent multimedia = new Intent(this, multi1.class);
        startActivity(multimedia);
        finish();
    }*/
}