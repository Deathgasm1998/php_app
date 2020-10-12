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

    public void logo(View view) {
        Intent logo= new Intent(this, MainActivity.class);
        startActivity(logo);
        finish();
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

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    public void Multimedia(View view) {
        Intent multimedia = new Intent(this, multi_inter1.class);
        startActivity(multimedia);
        finish();
    }

    //--------------------------------------------------------------------------
    public void Multimedia2(View view) {
        Intent multimedia2 = new Intent(this, multi_inter2.class);
        startActivity(multimedia2);
        finish();
    }
    //--------------------------------------------------------------------------
    public void Multimedia3(View view) {
        Intent multimedia3 = new Intent(this, multi_inter3.class);
        startActivity(multimedia3);
        finish();
    }

    //--------------------------------------------------------------------------
    public void Multimedia4(View view) {
        Intent multimedia4 = new Intent(this, multi_inter4.class);
        startActivity(multimedia4);
        finish();
    }

    //--------------------------------------------------------------------------
    public void Multimedia5(View view) {
        Intent multimedia5 = new Intent(this, multi_inter5.class);
        startActivity(multimedia5);
        finish();
    }

    //--------------------------------------------------------------------------
    public void Multimedia6(View view) {
        Intent multimedia6 = new Intent(this, multi_inter6.class);
        startActivity(multimedia6);
        finish();
    }
}