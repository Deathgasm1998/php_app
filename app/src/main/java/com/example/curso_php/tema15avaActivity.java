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

public class tema15avaActivity extends AppCompatActivity {
    DatabaseReference t15reference;
    RecyclerView t15recyclerView;
    ArrayList<Temava_15> t15list;
    AdapAV15 t15adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ava15);

        t15recyclerView = (RecyclerView) findViewById(R.id.rvtema15);
        t15recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t15list = new ArrayList<Temava_15>();

        t15reference = FirebaseDatabase.getInstance().getReference().child("avanzado").child("tema15");
        t15reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t15list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temava_15 t15 = dataSnapshot1.getValue(Temava_15.class);
                    t15list.add(t15);
                }
                t15adapter = new AdapAV15(tema15avaActivity.this,t15list);
                t15recyclerView.setAdapter(t15adapter);
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
        Intent anterior = new Intent(this, tema14avaActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema16avaActivity.class);
        startActivity(siguiente);
        finish();
    }

}