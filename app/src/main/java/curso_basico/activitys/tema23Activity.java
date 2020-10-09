package curso_basico.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_basico.adapters.AdapT23;
import com.example.curso_php.R;
import com.example.curso_php.contenido_basico;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_basico.temas.Tema_23;

public class tema23Activity extends AppCompatActivity {

    DatabaseReference t23reference;
    RecyclerView t23recyclerView;
    ArrayList<Tema_23> t23list;
    AdapT23 t23adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema23);

        t23recyclerView = (RecyclerView) findViewById(R.id.rvtema23);
        t23recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t23list = new ArrayList<Tema_23>();

        t23reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema23");
        t23reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t23list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_23 t23 = dataSnapshot1.getValue(Tema_23.class);
                    t23list.add(t23);
                }
                t23adapter = new AdapT23(tema23Activity.this, t23list);
                t23recyclerView.setAdapter(t23adapter);
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

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void ant_tema(View view) {
        Intent anterior = new Intent(this, tema22Activity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema24Activity.class);
        startActivity(siguiente);
        finish();
    }
}