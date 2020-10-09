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

import curso_intermedio.adapters.AdapIT1;
import curso_intermedio.adapters.AdapIT3;
import curso_intermedio.temas.Temain_1;
import curso_intermedio.temas.Temain_3;

public class tema3inActivity extends AppCompatActivity {
    DatabaseReference t3reference;
    RecyclerView t3recyclerView;
    ArrayList<Temain_3> t3list;
    AdapIT3 t3adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter3);


        t3recyclerView = (RecyclerView) findViewById(R.id.rvtema3);
        t3recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t3list = new ArrayList<Temain_3>();

        t3reference = FirebaseDatabase.getInstance().getReference().child("intermedio").child("tema3");
        t3reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t3list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temain_3 t3 = dataSnapshot1.getValue(Temain_3.class);
                    t3list.add(t3);
                }
                t3adapter = new AdapIT3(tema3inActivity.this,t3list);
                t3recyclerView.setAdapter(t3adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(tema3inActivity.this,"Opssss.... Algo va mal",Toast.LENGTH_SHORT).show();
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
        Intent anterior = new Intent(this, tema2inActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema4inActivity.class);
        startActivity(siguiente);
        finish();
    }
}