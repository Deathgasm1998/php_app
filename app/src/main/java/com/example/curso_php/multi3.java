package com.example.curso_php;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class multi3 extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi3);


        MediaController mediaController = new MediaController(this);

        videoView = findViewById(R.id.vid);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);



        Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/php-app-5b4e1.appspot.com/o/Multimedia%2Fvideoplayback3.mp4?alt=media&token=1869bc0c-e7e9-46fb-a3de-520f33b515c1");
        videoView.setVideoURI(uri);
        videoView.start();

    }


    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void ant_tema(View view) {
        Intent anterior = new Intent(this, multi_basico.class);
        startActivity(anterior);
        finish();
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}