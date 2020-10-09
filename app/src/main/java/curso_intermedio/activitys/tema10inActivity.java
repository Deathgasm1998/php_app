package curso_intermedio.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_intermedio.adapters.AdapIT10;
import com.example.curso_php.R;
import com.example.curso_php.contenido_intermedio;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_intermedio.temas.Temain_10;

public class tema10inActivity extends AppCompatActivity {
    DatabaseReference t10reference;
    RecyclerView t10recyclerView;
    ArrayList<Temain_10> t10list;
    AdapIT10 t10adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter10);

        t10recyclerView = (RecyclerView) findViewById(R.id.rvtema10);
        t10recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t10list = new ArrayList<Temain_10>();

        t10reference = FirebaseDatabase.getInstance().getReference().child("intermedio").child("tema10");
        t10reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t10list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temain_10 t10 = dataSnapshot1.getValue(Temain_10.class);
                    t10list.add(t10);
                }
                t10adapter = new AdapIT10(tema10inActivity.this,t10list);
                t10recyclerView.setAdapter(t10adapter);
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
        Intent anterior = new Intent(this, tema9inActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema11inActivity.class);
        startActivity(siguiente);
        finish();
    }
}