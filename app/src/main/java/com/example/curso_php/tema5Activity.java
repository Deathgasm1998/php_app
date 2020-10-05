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

public class tema5Activity extends AppCompatActivity {

    DatabaseReference t5reference;
    RecyclerView t5recyclerView;
    ArrayList<Tema_5> t5list;
    AdapT5 t5adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema5);

        t5recyclerView = (RecyclerView) findViewById(R.id.rvtema5);
        t5recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t5list = new ArrayList<Tema_5>();

        t5reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema5");
        t5reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t5list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_5 t5 = dataSnapshot1.getValue(Tema_5.class);
                    t5list.add(t5);
                }
                t5adapter = new AdapT5(tema5Activity.this,t5list);
                t5recyclerView.setAdapter(t5adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}