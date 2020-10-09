package curso_basico.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.curso_php.R;
import com.example.curso_php.contenido_basico;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_basico.temas.Tema_1;
import curso_basico.adapters.AdapT1;


public class tema1 extends AppCompatActivity {

    DatabaseReference t1reference;
    RecyclerView t1recyclerView;
    ArrayList<Tema_1> t1list;
    AdapT1 t1adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema1);

        t1recyclerView = (RecyclerView) findViewById(R.id.rvtema1);
        t1recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t1list = new ArrayList<Tema_1>();

        t1reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema1");
        t1reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t1list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_1 t1 = dataSnapshot1.getValue(Tema_1.class);
                    t1list.add(t1);
                }
                t1adapter = new AdapT1(tema1.this,t1list);
                t1recyclerView.setAdapter(t1adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(tema1.this,"Opssss.... Algo va mal",Toast.LENGTH_SHORT).show();
            }
        });


    }


    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void Anterior(View view) {
        Intent anterior = new Intent(this, contenido_basico.class);
        startActivity(anterior);
        finish();
    }

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema2Activity.class);
        startActivity(siguiente);
        finish();
    }
}