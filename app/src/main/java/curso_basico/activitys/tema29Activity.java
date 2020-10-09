package curso_basico.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_basico.adapters.AdapT29;
import com.example.curso_php.R;
import com.example.curso_php.contenido_basico;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_basico.temas.Tema_29;

public class tema29Activity extends AppCompatActivity {
    DatabaseReference t29reference;
    RecyclerView t29recyclerView;
    ArrayList<Tema_29> t29list;
    AdapT29 t29adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema29);

        t29recyclerView = (RecyclerView) findViewById(R.id.rvtema29);
        t29recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t29list = new ArrayList<Tema_29>();

        t29reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema29");
        t29reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t29list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_29 t29 = dataSnapshot1.getValue(Tema_29.class);
                    t29list.add(t29);
                }
                t29adapter = new AdapT29(tema29Activity.this, t29list);
                t29recyclerView.setAdapter(t29adapter);
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
        Intent anterior = new Intent(this, tema28Activity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema30Activity.class);
        startActivity(siguiente);
        finish();
    }

}