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

public class tema3inActivity extends AppCompatActivity {
    DatabaseReference t3ireference;
    RecyclerView t3irecyclerView;
    ArrayList<Temain_3> t3ilist;
    AdapIT3 t3iadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema3in);

        t3irecyclerView = (RecyclerView) findViewById(R.id.rvtema3);
        t3irecyclerView.setLayoutManager(new LinearLayoutManager(this));
        t3ilist = new ArrayList<Temain_3>();

        t3ireference = FirebaseDatabase.getInstance().getReference().child("intermedio").child("tema2");
        t3ireference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t3ilist.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temain_3 t3 = dataSnapshot1.getValue(Temain_3.class);
                    t3ilist.add(t3);
                }
                t3iadapter = new AdapIT3(tema3inActivity.this,t3ilist);
                t3irecyclerView.setAdapter(t3iadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}