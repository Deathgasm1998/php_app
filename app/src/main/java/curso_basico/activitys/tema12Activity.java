package curso_basico.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_basico.adapters.AdapT12;
import com.example.curso_php.R;
import curso_basico.temas.Tema_12;
import com.example.curso_php.contenido_basico;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class tema12Activity extends AppCompatActivity {

    DatabaseReference t12reference;
    RecyclerView t12recyclerView;
    ArrayList<Tema_12> t12list;
    AdapT12 t12adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema12);


        t12recyclerView = (RecyclerView) findViewById(R.id.rvtema12);
        t12recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t12list = new ArrayList<Tema_12>();

        t12reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema12");
        t12reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t12list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_12 t12 = dataSnapshot1.getValue(Tema_12.class);
                    t12list.add(t12);
                }
                t12adapter = new AdapT12(tema12Activity.this,t12list);
                t12recyclerView.setAdapter(t12adapter);
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
        Intent anterior = new Intent(this, tema11Activity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema13Activity.class);
        startActivity(siguiente);
        finish();
    }
}