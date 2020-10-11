package com.example.curso_php;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import pl.droidsonroids.gif.GifImageView;

public class SplashActivity extends Activity {
    private final int DURACION_SPLASH = 3000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        //Agregar animación
        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);
        Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);

        ImageView ivSplash = findViewById(R.id.ivSplash);
        GifImageView gifload = findViewById(R.id.gifload);

        ivSplash.setAnimation(animacion1);
        gifload.setAnimation(animacion2);
        //termina agregar animacion

        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);
    }
}
