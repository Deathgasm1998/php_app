package curso_intermedio.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.curso_php.R;
import curso_intermedio.temas.Temain_20;
import com.example.curso_php.contenido_intermedio;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_intermedio.adapters.AdapIT20;

public class tema20inActivity extends AppCompatActivity {
    DatabaseReference t20reference;
    RecyclerView t20recyclerView;
    ArrayList<Temain_20> t20list;
    AdapIT20 t20adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter20);

        t20recyclerView = (RecyclerView) findViewById(R.id.rvtema20);
        t20recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t20list = new ArrayList<Temain_20>();

        t20reference = FirebaseDatabase.getInstance().getReference().child("intermedio").child("tema20");
        t20reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t20list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temain_20 t20 = dataSnapshot1.getValue(Temain_20.class);
                    t20list.add(t20);
                }
                t20adapter = new AdapIT20(tema20inActivity.this,t20list);
                t20recyclerView.setAdapter(t20adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void Anterior(View view) {
        Intent anterior = new Intent(this, contenido_intermedio.class);
        startActivity(anterior);
        finish();
    }

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void ant_tema(View view) {
        Intent anterior = new Intent(this, tema19inActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

  /*  public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema11inActivity.class);
        startActivity(siguiente);
        finish();
    }*/
}