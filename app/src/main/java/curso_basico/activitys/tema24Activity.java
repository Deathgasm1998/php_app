package curso_basico.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_basico.adapters.AdapT24;
import com.example.curso_php.R;
import com.example.curso_php.contenido_basico;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_basico.temas.Tema_24;

public class tema24Activity extends AppCompatActivity {

    DatabaseReference t24reference;
    RecyclerView t24recyclerView;
    ArrayList<Tema_24> t24list;
    AdapT24 t24adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema24);

        t24recyclerView = (RecyclerView) findViewById(R.id.rvtema24);
        t24recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t24list = new ArrayList<Tema_24>();

        t24reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema24");
        t24reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t24list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_24 t24 = dataSnapshot1.getValue(Tema_24.class);
                    t24list.add(t24);
                }
                t24adapter = new AdapT24(tema24Activity.this, t24list);
                t24recyclerView.setAdapter(t24adapter);
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
        Intent anterior = new Intent(this, tema23Activity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema25Activity.class);
        startActivity(siguiente);
        finish();
    }
}