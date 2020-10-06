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

import curso_basico.AdapT2;
import curso_basico.Tema_2;
import curso_basico.tema2Activity;

public class tema2inActivity extends AppCompatActivity {

    DatabaseReference t2ireference;
    RecyclerView t2irecyclerView;
    ArrayList<Temain_2> t2ilist;
    AdapIT2 t2iadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema2in);

        t2irecyclerView = (RecyclerView) findViewById(R.id.rvtema2);
        t2irecyclerView.setLayoutManager(new LinearLayoutManager(this));
        t2ilist = new ArrayList<Temain_2>();

        t2ireference = FirebaseDatabase.getInstance().getReference().child("intermedio").child("tema2");
        t2ireference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t2ilist.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temain_2 t2 = dataSnapshot1.getValue(Temain_2.class);
                    t2ilist.add(t2);
                }
                t2iadapter = new AdapIT2(tema2inActivity.this,t2ilist);
                t2irecyclerView.setAdapter(t2iadapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}