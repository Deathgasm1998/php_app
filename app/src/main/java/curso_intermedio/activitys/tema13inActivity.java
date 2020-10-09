package curso_intermedio.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_intermedio.adapters.AdapIT13;
import com.example.curso_php.R;
import com.example.curso_php.contenido_intermedio;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_intermedio.temas.Temain_13;

public class tema13inActivity extends AppCompatActivity {
    DatabaseReference t13reference;
    RecyclerView t13recyclerView;
    ArrayList<Temain_13> t13list;
    AdapIT13 t13adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter13);

        t13recyclerView = (RecyclerView) findViewById(R.id.rvtema13);
        t13recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t13list = new ArrayList<Temain_13>();

        t13reference = FirebaseDatabase.getInstance().getReference().child("intermedio").child("tema13");
        t13reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t13list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temain_13 t13 = dataSnapshot1.getValue(Temain_13.class);
                    t13list.add(t13);
                }
                t13adapter = new AdapIT13(tema13inActivity.this,t13list);
                t13recyclerView.setAdapter(t13adapter);
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
        Intent anterior = new Intent(this, tema12inActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema14inActivity.class);
        startActivity(siguiente);
        finish();
    }
}