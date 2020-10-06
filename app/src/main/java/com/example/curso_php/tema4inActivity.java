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

public class tema4inActivity extends AppCompatActivity {
    DatabaseReference t4ireference;
    RecyclerView t4irecyclerView;
    ArrayList<Temain_4> t4ilist;
    AdapIT4 t4iadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema4in);

        t4irecyclerView = (RecyclerView) findViewById(R.id.rvtema4);
        t4irecyclerView.setLayoutManager(new LinearLayoutManager(this));
        t4ilist = new ArrayList<Temain_4>();

        t4ireference = FirebaseDatabase.getInstance().getReference().child("intermedio").child("tema4");
        t4ireference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t4ilist.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temain_4 t4 = dataSnapshot1.getValue(Temain_4.class);
                    t4ilist.add(t4);
                }
                t4iadapter = new AdapIT4(tema4inActivity.this,t4ilist);
                t4irecyclerView.setAdapter(t4iadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}