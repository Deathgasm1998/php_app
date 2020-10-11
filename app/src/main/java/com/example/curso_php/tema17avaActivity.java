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

public class tema17avaActivity extends AppCompatActivity {
    DatabaseReference t17reference;
    RecyclerView t17recyclerView;
    ArrayList<Temava_17> t17list;
    AdapAV17 t17adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ava17);

        t17recyclerView = (RecyclerView) findViewById(R.id.rvtema17);
        t17recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t17list = new ArrayList<Temava_17>();

        t17reference = FirebaseDatabase.getInstance().getReference().child("avanzado").child("tema17");
        t17reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t17list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temava_17 t17 = dataSnapshot1.getValue(Temava_17.class);
                    t17list.add(t17);
                }
                t17adapter = new AdapAV17(tema17avaActivity.this,t17list);
                t17recyclerView.setAdapter(t17adapter);
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
        Intent anterior = new Intent(this, tema16avaActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema18avaActivity.class);
        startActivity(siguiente);
        finish();
    }

}