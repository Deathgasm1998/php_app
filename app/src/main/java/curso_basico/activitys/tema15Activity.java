package curso_basico.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_basico.adapters.AdapT15;
import com.example.curso_php.R;
import curso_basico.temas.Tema_15;
import com.example.curso_php.contenido_basico;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class tema15Activity extends AppCompatActivity {

    DatabaseReference t15reference;
    RecyclerView t15recyclerView;
    ArrayList<Tema_15> t15list;
    AdapT15 t15adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema15);


        t15recyclerView = (RecyclerView) findViewById(R.id.rvtema15);
        t15recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t15list = new ArrayList<Tema_15>();

        t15reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema15");
        t15reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t15list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_15 t15 = dataSnapshot1.getValue(Tema_15.class);
                    t15list.add(t15);
                }
                t15adapter = new AdapT15(tema15Activity.this,t15list);
                t15recyclerView.setAdapter(t15adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
    public void ant_tema(View view) {
        Intent anterior = new Intent(this, tema14Activity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema16Activity.class);
        startActivity(siguiente);
        finish();
    }
}