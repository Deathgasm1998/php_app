package curso_intermedio.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_intermedio.adapters.AdapIT12;
import com.example.curso_php.R;
import com.example.curso_php.contenido_intermedio;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_intermedio.temas.Temain_12;

public class tema12inActivity extends AppCompatActivity {
    DatabaseReference t12reference;
    RecyclerView t12recyclerView;
    ArrayList<Temain_12> t12list;
    AdapIT12 t12adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter12);

        t12recyclerView = (RecyclerView) findViewById(R.id.rvtema12);
        t12recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t12list = new ArrayList<Temain_12>();

        t12reference = FirebaseDatabase.getInstance().getReference().child("intermedio").child("tema12");
        t12reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t12list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temain_12 t12 = dataSnapshot1.getValue(Temain_12.class);
                    t12list.add(t12);
                }
                t12adapter = new AdapIT12(tema12inActivity.this,t12list);
                t12recyclerView.setAdapter(t12adapter);
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
        Intent anterior = new Intent(this, tema11inActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema13inActivity.class);
        startActivity(siguiente);
        finish();
    }
}