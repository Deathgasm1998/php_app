package curso_avanzado.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_avanzado.adapters.AdapAV2;
import com.example.curso_php.R;
import com.example.curso_php.contenido_avanzado;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_avanzado.temas.Temava_2;

public class tema2avaActivity extends AppCompatActivity {
    DatabaseReference t2reference;
    RecyclerView t2recyclerView;
    ArrayList<Temava_2> t2list;
    AdapAV2 t2adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ava2);

        t2recyclerView = (RecyclerView) findViewById(R.id.rvtema2);
        t2recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t2list = new ArrayList<Temava_2>();

        t2reference = FirebaseDatabase.getInstance().getReference().child("avanzado").child("tema2");
        t2reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t2list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temava_2 t2 = dataSnapshot1.getValue(Temava_2.class);
                    t2list.add(t2);
                }
                t2adapter = new AdapAV2(tema2avaActivity.this,t2list);
                t2recyclerView.setAdapter(t2adapter);
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
        Intent anterior = new Intent(this, tema1avaActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema3avaActivity.class);
        startActivity(siguiente);
        finish();
    }

}