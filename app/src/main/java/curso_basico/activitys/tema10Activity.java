package curso_basico.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_basico.adapters.AdapT10;
import com.example.curso_php.R;
import curso_basico.temas.Tema_10;
import com.example.curso_php.contenido_basico;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class tema10Activity extends AppCompatActivity {

    DatabaseReference t10reference;
    RecyclerView t10recyclerView;
    ArrayList<Tema_10> t10list;
    AdapT10 t10adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema10);


        t10recyclerView = (RecyclerView) findViewById(R.id.rvtema10);
        t10recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t10list = new ArrayList<Tema_10>();

        t10reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema10");
        t10reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t10list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_10 t10 = dataSnapshot1.getValue(Tema_10.class);
                    t10list.add(t10);
                }
                t10adapter = new AdapT10(tema10Activity.this,t10list);
                t10recyclerView.setAdapter(t10adapter);
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
        Intent anterior = new Intent(this, tema9Activity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema11Activity.class);
        startActivity(siguiente);
        finish();
    }
}