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

public class tema10avaActivity extends AppCompatActivity {
    DatabaseReference t10reference;
    RecyclerView t10recyclerView;
    ArrayList<Temava_10> t10list;
    AdapAV10 t10adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ava10);

        t10recyclerView = (RecyclerView) findViewById(R.id.rvtema10);
        t10recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t10list = new ArrayList<Temava_10>();

        t10reference = FirebaseDatabase.getInstance().getReference().child("avanzado").child("tema10");
        t10reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t10list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temava_10 t10 = dataSnapshot1.getValue(Temava_10.class);
                    t10list.add(t10);
                }
                t10adapter = new AdapAV10(tema10avaActivity.this,t10list);
                t10recyclerView.setAdapter(t10adapter);
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
        Intent anterior = new Intent(this, tema9avaActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema11avaActivity.class);
        startActivity(siguiente);
        finish();
    }

}