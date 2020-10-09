package curso_intermedio.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_intermedio.adapters.AdapIT17;
import com.example.curso_php.R;
import com.example.curso_php.contenido_intermedio;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_intermedio.temas.Temain_17;

public class tema17inActivity extends AppCompatActivity {
    DatabaseReference t17reference;
    RecyclerView t17recyclerView;
    ArrayList<Temain_17> t17list;
    AdapIT17 t17adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter17);

        t17recyclerView = (RecyclerView) findViewById(R.id.rvtema17);
        t17recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t17list = new ArrayList<Temain_17>();

        t17reference = FirebaseDatabase.getInstance().getReference().child("intermedio").child("tema17");
        t17reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t17list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temain_17 t17 = dataSnapshot1.getValue(Temain_17.class);
                    t17list.add(t17);
                }
                t17adapter = new AdapIT17(tema17inActivity.this,t17list);
                t17recyclerView.setAdapter(t17adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void Anterior(View view) {
        Intent anterior = new Intent(this, contenido_intermedio.class);
        startActivity(anterior);
        finish();
    }

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void ant_tema(View view) {
        Intent anterior = new Intent(this, tema16inActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema18inActivity.class);
        startActivity(siguiente);
        finish();
    }
}