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

public class tema19avaActivity extends AppCompatActivity {
    DatabaseReference t19reference;
    RecyclerView t19recyclerView;
    ArrayList<Temava_19> t19list;
    AdapAV19 t19adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ava19);

        t19recyclerView = (RecyclerView) findViewById(R.id.rvtema19);
        t19recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t19list = new ArrayList<Temava_19>();

        t19reference = FirebaseDatabase.getInstance().getReference().child("avanzado").child("tema19");
        t19reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t19list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temava_19 t19 = dataSnapshot1.getValue(Temava_19.class);
                    t19list.add(t19);
                }
                t19adapter = new AdapAV19(tema19avaActivity.this,t19list);
                t19recyclerView.setAdapter(t19adapter);
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
        Intent anterior = new Intent(this, tema18avaActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema20avaActivity.class);
        startActivity(siguiente);
        finish();
    }

}