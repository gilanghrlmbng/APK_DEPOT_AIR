package com.e.bismillahuas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {
    TextView appname;
    ImageView logo_univ,logo_citiasia;
    LottieAnimationView lottieAnimationView;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        animation= AnimationUtils.loadAnimation(this,R.anim.splashanim);
        appname=findViewById(R.id.tv);
        logo_univ=findViewById(R.id.logo_univ);
        logo_citiasia=findViewById(R.id.logo_citiasiainc);
        lottieAnimationView=findViewById(R.id.splash);
        appname.setAnimation(animation);
        logo_univ.setAnimation(animation);
        logo_citiasia.setAnimation(animation);
        logo_citiasia.animate().translationY(2350).setDuration(1500).setStartDelay(2100);
        logo_univ.animate().translationY(2350).setDuration(1500).setStartDelay(2100);
        appname.animate().translationY(2350).setDuration(1500).setStartDelay(3100);
        lottieAnimationView.animate().translationY(2100).setDuration(1000).setStartDelay(3000);
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(getApplicationContext(),Login.class));
            finish();
        },5500L);
    }
}