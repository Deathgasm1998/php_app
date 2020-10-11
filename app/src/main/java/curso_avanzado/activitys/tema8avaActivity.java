package curso_avanzado.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_avanzado.adapters.AdapAV8;
import com.example.curso_php.R;
import com.example.curso_php.contenido_avanzado;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_avanzado.temas.Temava_8;

public class tema8avaActivity extends AppCompatActivity {
    DatabaseReference t8reference;
    RecyclerView t8recyclerView;
    ArrayList<Temava_8> t8list;
    AdapAV8 t8adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ava8);

        t8recyclerView = (RecyclerView) findViewById(R.id.rvtema8);
        t8recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t8list = new ArrayList<Temava_8>();

        t8reference = FirebaseDatabase.getInstance().getReference().child("avanzado").child("tema8");
        t8reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t8list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temava_8 t8 = dataSnapshot1.getValue(Temava_8.class);
                    t8list.add(t8);
                }
                t8adapter = new AdapAV8(tema8avaActivity.this,t8list);
                t8recyclerView.setAdapter(t8adapter);
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
        Intent anterior = new Intent(this, tema7avaActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema9avaActivity.class);
        startActivity(siguiente);
        finish();
    }

}