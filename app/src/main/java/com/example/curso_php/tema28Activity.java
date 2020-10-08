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

public class tema28Activity extends AppCompatActivity {
    DatabaseReference t28reference;
    RecyclerView t28recyclerView;
    ArrayList<Tema_28> t28list;
    AdapT28 t28adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema28);

        t28recyclerView = (RecyclerView) findViewById(R.id.rvtema28);
        t28recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t28list = new ArrayList<Tema_28>();

        t28reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema28");
        t28reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t28list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_28 t28 = dataSnapshot1.getValue(Tema_28.class);
                    t28list.add(t28);
                }
                t28adapter = new AdapT28(tema28Activity.this, t28list);
                t28recyclerView.setAdapter(t28adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void Anterior(View view) {
        Intent anterior = new Intent(this, contenido_basico.class);
        startActivity(anterior);
        finish();
    }

}