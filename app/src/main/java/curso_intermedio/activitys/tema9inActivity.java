package curso_intermedio.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import curso_intermedio.adapters.AdapIT9;
import com.example.curso_php.R;
import curso_intermedio.temas.Temain_9;
import com.example.curso_php.contenido_intermedio;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class tema9inActivity extends AppCompatActivity {
    DatabaseReference t9reference;
    RecyclerView t9recyclerView;
    ArrayList<Temain_9> t9list;
    AdapIT9 t9adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter9);

        t9recyclerView = (RecyclerView) findViewById(R.id.rvtema9);
        t9recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t9list = new ArrayList<Temain_9>();

        t9reference = FirebaseDatabase.getInstance().getReference().child("intermedio").child("tema9");
        t9reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t9list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Temain_9 t9 = dataSnapshot1.getValue(Temain_9.class);
                    t9list.add(t9);
                }
                t9adapter = new AdapIT9(tema9inActivity.this,t9list);
                t9recyclerView.setAdapter(t9adapter);
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
        Intent anterior = new Intent(this, tema8inActivity.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema10inActivity.class);
        startActivity(siguiente);
        finish();
    }

}