package curso_basico.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_basico.adapters.AdapT30;
import com.example.curso_php.R;
import com.example.curso_php.contenido_basico;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_basico.temas.Tema_30;

public class tema30Activity extends AppCompatActivity {
    DatabaseReference t30reference;
    RecyclerView t30recyclerView;
    ArrayList<Tema_30> t30list;
    AdapT30 t30adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema30);

        t30recyclerView = (RecyclerView) findViewById(R.id.rvtema30);
        t30recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t30list = new ArrayList<Tema_30>();

        t30reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema30");
        t30reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t30list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_30 t30 = dataSnapshot1.getValue(Tema_30.class);
                    t30list.add(t30);
                }
                t30adapter = new AdapT30(tema30Activity.this, t30list);
                t30recyclerView.setAdapter(t30adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void Anterior(View view) {
        Intent anterior = new Intent(this, contenido_basico.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void ant_tema(View view) {
        Intent anterior = new Intent(this, tema29Activity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   /* public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema29Activity.class);
        startActivity(siguiente);
        finish();
    }
*/
}