package curso_basico.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_basico.adapters.AdapT27;
import com.example.curso_php.R;
import com.example.curso_php.contenido_basico;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_basico.temas.Tema_27;

public class tema27Activity extends AppCompatActivity {
    DatabaseReference t27reference;
    RecyclerView t27recyclerView;
    ArrayList<Tema_27> t27list;
    AdapT27 t27adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema27);

        t27recyclerView = (RecyclerView) findViewById(R.id.rvtema27);
        t27recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t27list = new ArrayList<Tema_27>();

        t27reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema27");
        t27reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t27list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_27 t25 = dataSnapshot1.getValue(Tema_27.class);
                    t27list.add(t25);
                }
                t27adapter = new AdapT27(tema27Activity.this, t27list);
                t27recyclerView.setAdapter(t27adapter);
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
        Intent anterior = new Intent(this, tema26Activity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema28Activity.class);
        startActivity(siguiente);
        finish();
    }
}