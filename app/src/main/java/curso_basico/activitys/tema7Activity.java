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

import curso_basico.adapters.AdapT7;
import curso_basico.temas.Tema_7;

public class tema7Activity extends AppCompatActivity {

    DatabaseReference t7reference;
    RecyclerView t7recyclerview;
    ArrayList<Tema_7> t7list;
    AdapT7 t7adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema7);

        t7recyclerview = (RecyclerView) findViewById(R.id.rvtema7);
        t7recyclerview.setLayoutManager(new LinearLayoutManager(this));
        t7list = new ArrayList<Tema_7>();

        t7reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema7");
        t7reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t7list.clear();
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_7 t7 = dataSnapshot1.getValue(Tema_7.class);
                    t7list.add(t7);
                }
                t7adapter = new AdapT7(tema7Activity.this,t7list);
                t7recyclerview.setAdapter(t7adapter);
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
        Intent anterior = new Intent(this, tema6Activity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema8Activity.class);
        startActivity(siguiente);
        finish();
    }
}