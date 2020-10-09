package curso_basico.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_basico.adapters.AdapT14;
import com.example.curso_php.R;
import curso_basico.temas.Tema_14;
import com.example.curso_php.contenido_basico;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class tema14Activity extends AppCompatActivity {

    DatabaseReference t14reference;
    RecyclerView t14recyclerView;
    ArrayList<Tema_14> t14list;
    AdapT14 t14adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema14);


        t14recyclerView = (RecyclerView) findViewById(R.id.rvtema14);
        t14recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t14list = new ArrayList<Tema_14>();

        t14reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema14");
        t14reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t14list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_14 t14 = dataSnapshot1.getValue(Tema_14.class);
                    t14list.add(t14);
                }
                t14adapter = new AdapT14(tema14Activity.this,t14list);
                t14recyclerView.setAdapter(t14adapter);
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
        Intent anterior = new Intent(this, tema13Activity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema15Activity.class);
        startActivity(siguiente);
        finish();
    }
}