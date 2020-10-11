package curso_avanzado.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_avanzado.adapters.AdapAV6;
import com.example.curso_php.R;
import com.example.curso_php.contenido_avanzado;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_avanzado.temas.Temava_6;

public class tema6avaActivity extends AppCompatActivity {
    DatabaseReference t6reference;
    RecyclerView t6recyclerView;
    ArrayList<Temava_6> t6list;
    AdapAV6 t6adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ava6);

        t6recyclerView = (RecyclerView) findViewById(R.id.rvtema6);
        t6recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t6list = new ArrayList<Temava_6>();

        t6reference = FirebaseDatabase.getInstance().getReference().child("avanzado").child("tema6");
        t6reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t6list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temava_6 t6 = dataSnapshot1.getValue(Temava_6.class);
                    t6list.add(t6);
                }
                t6adapter = new AdapAV6(tema6avaActivity.this,t6list);
                t6recyclerView.setAdapter(t6adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void Anterior(View view) {
        Intent anterior = new Intent(this, contenido_avanzado.class);
        startActivity(anterior);
        finish();
    }


    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void ant_tema(View view) {
        Intent anterior = new Intent(this, tema5avaActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema7avaActivity.class);
        startActivity(siguiente);
        finish();
    }

}