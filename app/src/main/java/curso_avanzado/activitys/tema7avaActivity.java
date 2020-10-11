package curso_avanzado.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_avanzado.adapters.AdapAV7;
import com.example.curso_php.R;
import com.example.curso_php.contenido_avanzado;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_avanzado.temas.Temava_7;

public class tema7avaActivity extends AppCompatActivity {
    DatabaseReference t7reference;
    RecyclerView t7recyclerView;
    ArrayList<Temava_7> t7list;
    AdapAV7 t7adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ava7);

        t7recyclerView = (RecyclerView) findViewById(R.id.rvtema7);
        t7recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t7list = new ArrayList<Temava_7>();

        t7reference = FirebaseDatabase.getInstance().getReference().child("avanzado").child("tema7");
        t7reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t7list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temava_7 t7 = dataSnapshot1.getValue(Temava_7.class);
                    t7list.add(t7);
                }
                t7adapter = new AdapAV7(tema7avaActivity.this,t7list);
                t7recyclerView.setAdapter(t7adapter);
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
        Intent anterior = new Intent(this, tema6avaActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema8avaActivity.class);
        startActivity(siguiente);
        finish();
    }

}