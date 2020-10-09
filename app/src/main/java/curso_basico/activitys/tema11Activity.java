package curso_basico.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_basico.adapters.AdapT11;
import com.example.curso_php.R;
import curso_basico.temas.Tema_11;
import com.example.curso_php.contenido_basico;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class tema11Activity extends AppCompatActivity {

    DatabaseReference t11reference;
    RecyclerView t11recyclerView;
    ArrayList<Tema_11> t11list;
    AdapT11 t11adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema11);


        t11recyclerView = (RecyclerView) findViewById(R.id.rvtema11);
        t11recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t11list = new ArrayList<Tema_11>();

        t11reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema11");
        t11reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t11list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_11 t11 = dataSnapshot1.getValue(Tema_11.class);
                    t11list.add(t11);
                }
                t11adapter = new AdapT11(tema11Activity.this,t11list);
                t11recyclerView.setAdapter(t11adapter);
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
        Intent anterior = new Intent(this, tema10Activity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema12Activity.class);
        startActivity(siguiente);
        finish();
    }
}