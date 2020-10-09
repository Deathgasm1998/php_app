package curso_intermedio.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_intermedio.adapters.AdapIT8;
import com.example.curso_php.R;
import curso_intermedio.temas.Temain_8;
import com.example.curso_php.contenido_intermedio;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class tema8inActivity extends AppCompatActivity {
    DatabaseReference t8reference;
    RecyclerView t8recyclerView;
    ArrayList<Temain_8> t8list;
    AdapIT8 t8adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter8);

        t8recyclerView = (RecyclerView) findViewById(R.id.rvtema8);
        t8recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t8list = new ArrayList<Temain_8>();

        t8reference = FirebaseDatabase.getInstance().getReference().child("intermedio").child("tema8");
        t8reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t8list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temain_8 t8 = dataSnapshot1.getValue(Temain_8.class);
                    t8list.add(t8);
                }
                t8adapter = new AdapIT8(tema8inActivity.this,t8list);
                t8recyclerView.setAdapter(t8adapter);
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
        Intent anterior = new Intent(this, tema7inActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema9inActivity.class);
        startActivity(siguiente);
        finish();
    }
}