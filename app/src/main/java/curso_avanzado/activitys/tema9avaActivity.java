package curso_avanzado.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_avanzado.adapters.AdapAV9;
import com.example.curso_php.R;
import com.example.curso_php.contenido_avanzado;
import com.example.curso_php.tema10avaActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_avanzado.temas.Temava_9;

public class tema9avaActivity extends AppCompatActivity {
    DatabaseReference t9reference;
    RecyclerView t9recyclerView;
    ArrayList<Temava_9> t9list;
    AdapAV9 t9adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ava9);

        t9recyclerView = (RecyclerView) findViewById(R.id.rvtema9);
        t9recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t9list = new ArrayList<Temava_9>();

        t9reference = FirebaseDatabase.getInstance().getReference().child("avanzado").child("tema9");
        t9reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t9list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temava_9 t9 = dataSnapshot1.getValue(Temava_9.class);
                    t9list.add(t9);
                }
                t9adapter = new AdapAV9(tema9avaActivity.this,t9list);
                t9recyclerView.setAdapter(t9adapter);
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
        Intent anterior = new Intent(this, tema8avaActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema10avaActivity.class);
        startActivity(siguiente);
        finish();
    }

}