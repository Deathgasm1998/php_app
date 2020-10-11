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

public class tema11avaActivity extends AppCompatActivity {
    DatabaseReference t11reference;
    RecyclerView t11recyclerView;
    ArrayList<Temava_11> t11list;
    AdapAV11 t11adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ava11);

        t11recyclerView = (RecyclerView) findViewById(R.id.rvtema11);
        t11recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t11list = new ArrayList<Temava_11>();

        t11reference = FirebaseDatabase.getInstance().getReference().child("avanzado").child("tema11");
        t11reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t11list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temava_11 t11 = dataSnapshot1.getValue(Temava_11.class);
                    t11list.add(t11);
                }
                t11adapter = new AdapAV11(tema11avaActivity.this,t11list);
                t11recyclerView.setAdapter(t11adapter);
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
        Intent anterior = new Intent(this, tema10avaActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema12avaActivity.class);
        startActivity(siguiente);
        finish();
    }

}