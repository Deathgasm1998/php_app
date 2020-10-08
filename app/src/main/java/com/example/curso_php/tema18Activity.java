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

public class tema18Activity extends AppCompatActivity {

    DatabaseReference t18reference;
    RecyclerView t18recyclerView;
    ArrayList<Tema_18> t18list;
    AdapT18 t18adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema18);


        t18recyclerView = (RecyclerView) findViewById(R.id.rvtema18);
        t18recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t18list = new ArrayList<Tema_18>();

        t18reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema18");
        t18reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t18list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_18 t18 = dataSnapshot1.getValue(Tema_18.class);
                    t18list.add(t18);
                }
                t18adapter = new AdapT18(tema18Activity.this,t18list);
                t18recyclerView.setAdapter(t18adapter);
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