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

import curso_basico.adapters.AdapT8;
import curso_basico.temas.Tema_8;

public class tema8Activity extends AppCompatActivity {

    DatabaseReference t8reference;
    RecyclerView t8recyclerview;
    ArrayList<Tema_8> t8list;
    AdapT8 t8adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema8);

        t8recyclerview = (RecyclerView) findViewById(R.id.rvtema8);
        t8recyclerview.setLayoutManager(new LinearLayoutManager(this));
        t8list = new ArrayList<Tema_8>();

        t8reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema8");
        t8reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t8list.clear();
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_8 t8 = dataSnapshot1.getValue(Tema_8.class);
                    t8list.add(t8);
                }
                t8adapter = new AdapT8(tema8Activity.this,t8list);
                t8recyclerview.setAdapter(t8adapter);
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
        Intent anterior = new Intent(this, tema7Activity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema9Activity.class);
        startActivity(siguiente);
        finish();
    }
}