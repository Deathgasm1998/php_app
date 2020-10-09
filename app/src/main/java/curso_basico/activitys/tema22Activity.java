package curso_basico.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_basico.adapters.AdapT22;
import com.example.curso_php.R;
import com.example.curso_php.contenido_basico;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_basico.temas.Tema_22;

public class tema22Activity extends AppCompatActivity {

    DatabaseReference t22reference;
    RecyclerView t22recyclerView;
    ArrayList<Tema_22> t22list;
    AdapT22 t22adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema22);

        t22recyclerView = (RecyclerView) findViewById(R.id.rvtema22);
        t22recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t22list = new ArrayList<Tema_22>();

        t22reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema22");
        t22reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t22list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_22 t22 = dataSnapshot1.getValue(Tema_22.class);
                    t22list.add(t22);
                }
                t22adapter = new AdapT22(tema22Activity.this, t22list);
                t22recyclerView.setAdapter(t22adapter);
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
        Intent anterior = new Intent(this, tema21Activity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema23Activity.class);
        startActivity(siguiente);
        finish();
    }
}