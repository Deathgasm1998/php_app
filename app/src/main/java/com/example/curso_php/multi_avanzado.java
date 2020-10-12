package com.example.curso_php;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class multi_avanzado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_avanzado);
    }

    //--------------------------------------------------------------------------
    public void Anterior(View view) {
        Intent anterior = new Intent(this, contenido_avanzado.class);
        startActivity(anterior);
        finish();
    }


    public void logo(View view) {
        Intent logo= new Intent(this, MainActivity.class);
        startActivity(logo);
        finish();
    }

    //--------------------------------------------------------------------------
    public void Multia(View view) {
        Intent multia = new Intent(this, multi_avanzado.class);
        startActivity(multia);
        finish();
    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    public void Multimedia(View view) {
        Intent multimedia = new Intent(this, multi_avan1.class);
        startActivity(multimedia);
        finish();
    }

    //--------------------------------------------------------------------------
    public void Multimedia2(View view) {
        Intent multimedia2 = new Intent(this, multi_avan2.class);
        startActivity(multimedia2);
        finish();
    }
    //--------------------------------------------------------------------------
    public void Multimedia3(View view) {
        Intent multimedia3 = new Intent(this, multi_avan3.class);
        startActivity(multimedia3);
        finish();
    }

    //--------------------------------------------------------------------------
    public void Multimedia4(View view) {
        Intent multimedia4 = new Intent(this, multi_avan4.class);
        startActivity(multimedia4);
        finish();
    }

    //--------------------------------------------------------------------------
    public void Multimedia5(View view) {
        Intent multimedia5 = new Intent(this, multi_avan5.class);
        startActivity(multimedia5);
        finish();
    }

    //--------------------------------------------------------------------------
    public void Multimedia6(View view) {
        Intent multimedia6 = new Intent(this, multi_avan6.class);
        startActivity(multimedia6);
        finish();
    }
}