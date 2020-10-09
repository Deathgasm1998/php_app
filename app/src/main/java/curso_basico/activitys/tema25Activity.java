package curso_basico.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_basico.adapters.AdapT25;
import com.example.curso_php.R;
import com.example.curso_php.contenido_basico;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_basico.temas.Tema_25;

public class tema25Activity extends AppCompatActivity {
    DatabaseReference t25reference;
    RecyclerView t25recyclerView;
    ArrayList<Tema_25> t25list;
    AdapT25 t25adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema25);

        t25recyclerView = (RecyclerView) findViewById(R.id.rvtema25);
        t25recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t25list = new ArrayList<Tema_25>();

        t25reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema25");
        t25reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t25list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_25 t25 = dataSnapshot1.getValue(Tema_25.class);
                    t25list.add(t25);
                }
                t25adapter = new AdapT25(tema25Activity.this, t25list);
                t25recyclerView.setAdapter(t25adapter);
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
        Intent anterior = new Intent(this, tema24Activity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema26Activity.class);
        startActivity(siguiente);
        finish();
    }
}