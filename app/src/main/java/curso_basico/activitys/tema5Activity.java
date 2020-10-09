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

import curso_basico.temas.Tema_5;
import curso_basico.adapters.AdapT5;

public class tema5Activity extends AppCompatActivity {

    DatabaseReference t5reference;
    RecyclerView t5recyclerView;
    ArrayList<Tema_5> t5list;
    AdapT5 t5adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema5);

        t5recyclerView = (RecyclerView) findViewById(R.id.rvtema5);
        t5recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t5list = new ArrayList<Tema_5>();

        t5reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema5");
        t5reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t5list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_5 t5 = dataSnapshot1.getValue(Tema_5.class);
                    t5list.add(t5);
                }
                t5adapter = new AdapT5(tema5Activity.this,t5list);
                t5recyclerView.setAdapter(t5adapter);
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
        Intent anterior = new Intent(this, tema4Activity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema6Activity.class);
        startActivity(siguiente);
        finish();
    }
}