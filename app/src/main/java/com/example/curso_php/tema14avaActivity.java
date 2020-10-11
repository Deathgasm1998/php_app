package com.example.curso_php;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_avanzado.activitys.tema9avaActivity;

public class tema14avaActivity extends AppCompatActivity {
    DatabaseReference t14reference;
    RecyclerView t14recyclerView;
    ArrayList<Temava_14> t14list;
    AdapAV14 t14adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ava14);

        t14recyclerView = (RecyclerView) findViewById(R.id.rvtema14);
        t14recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t14list = new ArrayList<Temava_14>();

        t14reference = FirebaseDatabase.getInstance().getReference().child("avanzado").child("tema14");
        t14reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t14list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temava_14 t14 = dataSnapshot1.getValue(Temava_14.class);
                    t14list.add(t14);
                }
                t14adapter = new AdapAV14(tema14avaActivity.this,t14list);
                t14recyclerView.setAdapter(t14adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void Anterior(View view) {
        Intent anterior = new Intent(this, contenido_avanzado.class);
        startActivity(anterior);
        finish();
    }


    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void ant_tema(View view) {
        Intent anterior = new Intent(this, tema13avaActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema15avaActivity.class);
        startActivity(siguiente);
        finish();
    }

}