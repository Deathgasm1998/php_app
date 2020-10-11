package curso_avanzado.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_avanzado.adapters.AdapAV5;
import com.example.curso_php.R;
import com.example.curso_php.contenido_avanzado;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_avanzado.temas.Temava_5;

public class tema5avaActivity extends AppCompatActivity {
    DatabaseReference t5reference;
    RecyclerView t5recyclerView;
    ArrayList<Temava_5> t5list;
    AdapAV5 t5adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ava5);

        t5recyclerView = (RecyclerView) findViewById(R.id.rvtema5);
        t5recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t5list = new ArrayList<Temava_5>();

        t5reference = FirebaseDatabase.getInstance().getReference().child("avanzado").child("tema5");
        t5reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t5list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temava_5 t5 = dataSnapshot1.getValue(Temava_5.class);
                    t5list.add(t5);
                }
                t5adapter = new AdapAV5(tema5avaActivity.this,t5list);
                t5recyclerView.setAdapter(t5adapter);
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
        Intent anterior = new Intent(this, tema4avaActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema6avaActivity.class);
        startActivity(siguiente);
        finish();
    }

}