package curso_basico.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_basico.adapters.AdapT13;
import com.example.curso_php.R;
import curso_basico.temas.Tema_13;
import com.example.curso_php.contenido_basico;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class tema13Activity extends AppCompatActivity {

    DatabaseReference t13reference;
    RecyclerView t13recyclerView;
    ArrayList<Tema_13> t13list;
    AdapT13 t13adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema13);


        t13recyclerView = (RecyclerView) findViewById(R.id.rvtema13);
        t13recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t13list = new ArrayList<Tema_13>();

        t13reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema13");
        t13reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t13list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_13 t13 = dataSnapshot1.getValue(Tema_13.class);
                    t13list.add(t13);
                }
                t13adapter = new AdapT13(tema13Activity.this,t13list);
                t13recyclerView.setAdapter(t13adapter);
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
        Intent anterior = new Intent(this, tema12Activity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema14Activity.class);
        startActivity(siguiente);
        finish();
    }
}