package curso_basico;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.curso_php.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class tema4Activity extends AppCompatActivity {

    DatabaseReference t4reference;
    RecyclerView t4recyclerView;
    ArrayList<Tema_4> t4list;
    AdapT4 t4adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema4);

        t4recyclerView = (RecyclerView) findViewById(R.id.rvtema4);
        t4recyclerView.setLayoutManager(new LinearLayoutManager(this));
        t4list = new ArrayList<Tema_4>();

        t4reference = FirebaseDatabase.getInstance().getReference().child("basico").child("tema4");
        t4reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t4list.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Tema_4 t4 = dataSnapshot1.getValue(Tema_4.class);
                    t4list.add(t4);
                }
                t4adapter = new AdapT4(tema4Activity.this,t4list);
                t4recyclerView.setAdapter(t4adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}