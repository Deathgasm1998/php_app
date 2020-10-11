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

public class tema18avaActivity extends AppCompatActivity {
    DatabaseReference t18reference;
    RecyclerView t18recyclerView;
    ArrayList<Temava_18> t18list;
    AdapAV18 t18adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ava18);

        t18recyclerView = (RecyclerView) findViewById(R.id.rvtema18);
        t18recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t18list = new ArrayList<Temava_18>();

        t18reference = FirebaseDatabase.getInstance().getReference().child("avanzado").child("tema18");
        t18reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t18list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temava_18 t18 = dataSnapshot1.getValue(Temava_18.class);
                    t18list.add(t18);
                }
                t18adapter = new AdapAV18(tema18avaActivity.this,t18list);
                t18recyclerView.setAdapter(t18adapter);
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
        Intent anterior = new Intent(this, tema17avaActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema19avaActivity.class);
        startActivity(siguiente);
        finish();
    }

}