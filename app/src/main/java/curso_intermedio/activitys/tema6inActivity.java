package curso_intermedio.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.curso_php.R;
import com.example.curso_php.contenido_intermedio;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_intermedio.adapters.AdapIT6;
import curso_intermedio.temas.Temain_6;

public class tema6inActivity extends AppCompatActivity {
    DatabaseReference t6reference;
    RecyclerView t6recyclerView;
    ArrayList<Temain_6> t6list;
    AdapIT6 t6adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter6);

        t6recyclerView = (RecyclerView) findViewById(R.id.rvtema6);
        t6recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t6list = new ArrayList<Temain_6>();

        t6reference = FirebaseDatabase.getInstance().getReference().child("intermedio").child("tema6");
        t6reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t6list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temain_6 t6 = dataSnapshot1.getValue(Temain_6.class);
                    t6list.add(t6);
                }
                t6adapter = new AdapIT6(tema6inActivity.this,t6list);
                t6recyclerView.setAdapter(t6adapter);
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
        Intent anterior = new Intent(this, tema5inActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema7inActivity.class);
        startActivity(siguiente);
        finish();
    }
}