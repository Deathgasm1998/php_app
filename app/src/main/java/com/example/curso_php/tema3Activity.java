package com.example.curso_php;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class tema3Activity extends AppCompatActivity {

    DatabaseReference t3reference;
    RecyclerView t3recyclerView;
    ArrayList<Tema_3> t3list;
    AdatT3 t3adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema3);

        t3recyclerView = (RecyclerView) findViewById(R.id.rvtema3);
        t3recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t3list = new ArrayList<Tema_3>();

        t3reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema3");
        t3reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t3list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_3 t3 = dataSnapshot1.getValue(Tema_3.class);
                    t3list.add(t3);
                }
                t3adapter = new AdatT3(tema3Activity.this,t3list);
                t3recyclerView.setAdapter(t3adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}