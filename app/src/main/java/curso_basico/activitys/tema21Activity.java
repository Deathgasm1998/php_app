package curso_basico.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_basico.adapters.AdapT21;
import com.example.curso_php.R;
import com.example.curso_php.contenido_basico;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_basico.temas.Tema_21;

public class tema21Activity extends AppCompatActivity {

    DatabaseReference t21reference;
    RecyclerView t21recyclerView;
    ArrayList<Tema_21> t21list;
    AdapT21 t21adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema21);

        t21recyclerView = (RecyclerView) findViewById(R.id.rvtema21);
        t21recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t21list = new ArrayList<Tema_21>();

        t21reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema21");
        t21reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t21list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_21 t21 = dataSnapshot1.getValue(Tema_21.class);
                    t21list.add(t21);
                }
                t21adapter = new AdapT21(tema21Activity.this, t21list);
                t21recyclerView.setAdapter(t21adapter);
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
        Intent anterior = new Intent(this, tema20Activity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema22Activity.class);
        startActivity(siguiente);
        finish();
    }
}