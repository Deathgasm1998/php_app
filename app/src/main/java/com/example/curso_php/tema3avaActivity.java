package com.example.curso_php;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.curso_php.R;
import com.example.curso_php.contenido_intermedio;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_intermedio.activitys.tema8inActivity;
import curso_intermedio.adapters.AdapIT6;
import curso_intermedio.temas.Temain_6;

public class tema3avaActivity extends AppCompatActivity {
    DatabaseReference t3reference;
    RecyclerView t3recyclerView;
    ArrayList<Temava_3> t3list;
    AdapAV3 t3adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ava3);

        t3recyclerView = (RecyclerView) findViewById(R.id.rvtema3);
        t3recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t3list = new ArrayList<Temava_3>();

        t3reference = FirebaseDatabase.getInstance().getReference().child("avanzado").child("tema3");
        t3reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t3list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temava_3 t3 = dataSnapshot1.getValue(Temava_3.class);
                    t3list.add(t3);
                }
                t3adapter = new AdapAV3(tema3avaActivity.this,t3list);
                t3recyclerView.setAdapter(t3adapter);
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
        Intent anterior = new Intent(this, tema2avaActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema4avaActivity.class);
        startActivity(siguiente);
        finish();
    }

}