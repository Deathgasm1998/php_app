package com.example.curso_php;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class multi_intermedio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_intermedio);
    }


    //--------------------------------------------------------------------------
    public void Anterior(View view) {
        Intent anterior = new Intent(this, contenido_intermedio.class);
        startActivity(anterior);
        finish();
    }

    //--------------------------------------------------------------------------
    public void Multii(View view) {
        Intent multii = new Intent(this, multi_intermedio.class);
        startActivity(multii);
        finish();
    }


 /*
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
    }

    //--------------------------------------------------------------------------
    public void Multimedia(View view) {
        Intent multimedia = new Intent(this, multi1.class);
        startActivity(multimedia);
        finish();
    }*/
}