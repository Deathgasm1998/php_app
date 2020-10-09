package curso_basico.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.curso_php.R;
import com.example.curso_php.contenido_basico;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_basico.temas.Tema_3;
import curso_basico.adapters.AdatT3;

public class tema3Activity extends AppCompatActivity {

    DatabaseReference t3reference;
    RecyclerView t3recyclerView;
    ArrayList<Tema_3> t3list;
    AdatT3 t3adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema3);

        t3recyclerView = (RecyclerView) findViewById(R.id.rvtema3);
        t3recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t3list = new ArrayList<Tema_3>();

        t3reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema3");
        t3reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t3list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_3 t3 = dataSnapshot1.getValue(Tema_3.class);
                    t3list.add(t3);
                }
                t3adapter = new AdatT3(tema3Activity.this,t3list);
                t3recyclerView.setAdapter(t3adapter);
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

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void ant_tema(View view) {
        Intent anterior = new Intent(this, tema2Activity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema4Activity.class);
        startActivity(siguiente);
        finish();
    }
}