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

public class tema13avaActivity extends AppCompatActivity {
    DatabaseReference t13reference;
    RecyclerView t13recyclerView;
    ArrayList<Temava_13> t13list;
    AdapAV13 t13adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ava13);

        t13recyclerView = (RecyclerView) findViewById(R.id.rvtema13);
        t13recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t13list = new ArrayList<Temava_13>();

        t13reference = FirebaseDatabase.getInstance().getReference().child("avanzado").child("tema13");
        t13reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t13list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temava_13 t13 = dataSnapshot1.getValue(Temava_13.class);
                    t13list.add(t13);
                }
                t13adapter = new AdapAV13(tema13avaActivity.this,t13list);
                t13recyclerView.setAdapter(t13adapter);
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
        Intent anterior = new Intent(this, tema12avaActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema14avaActivity.class);
        startActivity(siguiente);
        finish();
    }

}