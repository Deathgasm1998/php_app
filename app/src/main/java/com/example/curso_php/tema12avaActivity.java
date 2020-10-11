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

public class tema12avaActivity extends AppCompatActivity {
    DatabaseReference t12reference;
    RecyclerView t12recyclerView;
    ArrayList<Temava_12> t12list;
    AdapAV12 t12adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ava12);

        t12recyclerView = (RecyclerView) findViewById(R.id.rvtema12);
        t12recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t12list = new ArrayList<Temava_12>();

        t12reference = FirebaseDatabase.getInstance().getReference().child("avanzado").child("tema12");
        t12reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t12list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temava_12 t12 = dataSnapshot1.getValue(Temava_12.class);
                    t12list.add(t12);
                }
                t12adapter = new AdapAV12(tema12avaActivity.this,t12list);
                t12recyclerView.setAdapter(t12adapter);
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
        Intent anterior = new Intent(this, tema11avaActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema13avaActivity.class);
        startActivity(siguiente);
        finish();
    }

}