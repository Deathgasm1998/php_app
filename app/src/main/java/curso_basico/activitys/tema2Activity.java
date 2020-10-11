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

import curso_basico.temas.Tema_2;
import curso_basico.adapters.AdapT2;

public class tema2Activity extends AppCompatActivity {

    DatabaseReference t2reference;
    RecyclerView t2recyclerView;
    ArrayList<Tema_2> t2list;
    AdapT2 t2adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema2);

        t2recyclerView = (RecyclerView) findViewById(R.id.rvtema2);
        t2recyclerView.setLayoutManager(new LinearLayoutManager(this));
       t2list = new ArrayList<Tema_2>();

    t2reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema2");
        t2reference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            t2list.clear();

            for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
            {
                Tema_2 t2 = dataSnapshot1.getValue(Tema_2.class);
                t2list.add(t2);
            }
            t2adapter = new AdapT2(tema2Activity.this,t2list);
            t2recyclerView.setAdapter(t2adapter);

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    }) ;
}

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void Anterior(View view) {
        Intent anterior = new Intent(this, contenido_basico.class);
        startActivity(anterior);
        finish();
    }

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void ant_tema(View view) {
        Intent anterior = new Intent(this, tema1.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema3Activity.class);
        startActivity(siguiente);
        finish();
    }
}