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

public class tema20avaActivity extends AppCompatActivity {
    DatabaseReference t20reference;
    RecyclerView t20recyclerView;
    ArrayList<Temava_20> t20list;
    AdapAV20 t20adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ava20);

        t20recyclerView = (RecyclerView) findViewById(R.id.rvtema20);
        t20recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t20list = new ArrayList<Temava_20>();

        t20reference = FirebaseDatabase.getInstance().getReference().child("avanzado").child("tema20");
        t20reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t20list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temava_20 t20 = dataSnapshot1.getValue(Temava_20.class);
                    t20list.add(t20);
                }
                t20adapter = new AdapAV20(tema20avaActivity.this,t20list);
                t20recyclerView.setAdapter(t20adapter);
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
        Intent anterior = new Intent(this, tema19avaActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

   /* public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema11avaActivity.class);
        startActivity(siguiente);
        finish();
    }
*/
}