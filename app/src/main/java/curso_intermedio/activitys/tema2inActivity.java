package curso_intermedio.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.curso_php.R;
import com.example.curso_php.contenido_intermedio;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_intermedio.adapters.AdapIT2;
import curso_intermedio.temas.Temain_2;

public class tema2inActivity extends AppCompatActivity {
    DatabaseReference t2reference;
    RecyclerView t2recyclerView;
    ArrayList<Temain_2> t2list;
    AdapIT2 t2adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter2);


        t2recyclerView = (RecyclerView) findViewById(R.id.rvtema2);
        t2recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t2list = new ArrayList<Temain_2>();

        t2reference = FirebaseDatabase.getInstance().getReference().child("intermedio").child("tema2");
        t2reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t2list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temain_2 t2 = dataSnapshot1.getValue(Temain_2.class);
                    t2list.add(t2);
                }
                t2adapter = new AdapIT2(tema2inActivity.this,t2list);
                t2recyclerView.setAdapter(t2adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(tema2inActivity.this,"Opssss.... Algo va mal",Toast.LENGTH_SHORT).show();
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
        Intent anterior = new Intent(this, temai_1.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema3inActivity.class);
        startActivity(siguiente);
        finish();
    }

}