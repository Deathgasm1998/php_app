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

public class tema16avaActivity extends AppCompatActivity {
    DatabaseReference t16reference;
    RecyclerView t16recyclerView;
    ArrayList<Temava_16> t16list;
    AdapAV16 t16adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ava16);

        t16recyclerView = (RecyclerView) findViewById(R.id.rvtema16);
        t16recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t16list = new ArrayList<Temava_16>();

        t16reference = FirebaseDatabase.getInstance().getReference().child("avanzado").child("tema16");
        t16reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t16list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temava_16 t16 = dataSnapshot1.getValue(Temava_16.class);
                    t16list.add(t16);
                }
                t16adapter = new AdapAV16(tema16avaActivity.this,t16list);
                t16recyclerView.setAdapter(t16adapter);
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
        Intent anterior = new Intent(this, tema15avaActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema17avaActivity.class);
        startActivity(siguiente);
        finish();
    }

}