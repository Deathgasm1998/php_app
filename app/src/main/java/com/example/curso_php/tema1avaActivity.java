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

import curso_intermedio.adapters.AdapIT6;
import curso_intermedio.temas.Temain_6;

public class tema1avaActivity extends AppCompatActivity {
    DatabaseReference t1reference;
    RecyclerView t1recyclerView;
    ArrayList<Temava_1> t1list;
    AdapAV1 t1adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ava1);

        t1recyclerView = (RecyclerView) findViewById(R.id.rvtema1);
        t1recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t1list = new ArrayList<Temava_1>();

        t1reference = FirebaseDatabase.getInstance().getReference().child("avanzado").child("tema1");
        t1reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t1list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temava_1 t1 = dataSnapshot1.getValue(Temava_1.class);
                    t1list.add(t1);
                }
                t1adapter = new AdapAV1(tema1avaActivity.this,t1list);
                t1recyclerView.setAdapter(t1adapter);
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
}