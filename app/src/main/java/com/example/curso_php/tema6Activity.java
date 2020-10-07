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

public class tema6Activity extends AppCompatActivity {

    DatabaseReference t6reference;
    RecyclerView t6recyclerview;
    ArrayList<Tema_6> t6list;
    AdapT6 t6adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema6);

        t6recyclerview = (RecyclerView) findViewById(R.id.rvtema6);
        t6recyclerview.setLayoutManager(new LinearLayoutManager(this));
        t6list = new ArrayList<Tema_6>();

        t6reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema6");
        t6reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t6list.clear();
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_6 t6 = dataSnapshot1.getValue(Tema_6.class);
                    t6list.add(t6);
                }
                t6adapter = new AdapT6(tema6Activity.this,t6list);
                t6recyclerview.setAdapter(t6adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void Anterior(View view) {
        Intent anterior = new Intent(this, contenido_basico.class);
        startActivity(anterior);
        finish();
    }
}

