package curso_basico.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_basico.adapters.AdapT26;
import com.example.curso_php.R;
import com.example.curso_php.contenido_basico;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_basico.temas.Tema_26;

public class tema26Activity extends AppCompatActivity {
    DatabaseReference t26reference;
    RecyclerView t26recyclerView;
    ArrayList<Tema_26> t26list;
    AdapT26 t26adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema26);

        t26recyclerView = (RecyclerView) findViewById(R.id.rvtema26);
        t26recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t26list = new ArrayList<Tema_26>();

        t26reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema26");
        t26reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t26list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_26 t26 = dataSnapshot1.getValue(Tema_26.class);
                    t26list.add(t26);
                }
                t26adapter = new AdapT26(tema26Activity.this, t26list);
                t26recyclerView.setAdapter(t26adapter);
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
        Intent anterior = new Intent(this, tema25Activity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema27Activity.class);
        startActivity(siguiente);
        finish();
    }
}