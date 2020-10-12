package com.example.curso_php;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.curso_php.R;
import com.example.curso_php.contenido_intermedio;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import curso_intermedio.activitys.tema8inActivity;
import curso_intermedio.adapters.AdapIT6;
import curso_intermedio.temas.Temain_6;

public class multi1 extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi1);

        MediaController mediaController = new MediaController(this);

        videoView = findViewById(R.id.vid);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);



        Uri  uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/php-app-5b4e1.appspot.com/o/Multimedia%2Fvideoplayback.mp4?alt=media&token=20855931-14a9-45ef-bc25-017bd88cd3ca");
        videoView.setVideoURI(uri);
        videoView.start();


    }

    /*
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void Anterior(View view) {
        Intent anterior = new Intent(this, Curso.class);
        startActivity(anterior);
        finish();
    }*/


    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   public void ant_tema(View view) {
        Intent anterior = new Intent(this, multi_basico.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    /*public void sig_tema(View view) {
        Intent siguiente = new Intent(this, tema2avaActivity.class);
        startActivity(siguiente);
        finish();
    }*/

}