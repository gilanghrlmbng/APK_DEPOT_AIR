package com.e.bismillahuas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class Complete extends AppCompatActivity {
    TextView appname;
    LottieAnimationView lottieAnimationView;
    Animation animation;
    static final String id_channel="MyApp";
    static final int id_notifbuilder=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);
        NotificationManager notificationManager=(NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);

        Intent intentToApp = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pendingIntent= PendingIntent.getActivity(Complete.this,1,intentToApp, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder
                (Complete.this, id_channel)
                .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
                .setContentTitle("Gil's Water")
                .setContentText("Pesanan Berhasil")
                .setContentIntent(pendingIntent);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel=new NotificationChannel(id_channel, "Channel App",
                    NotificationManager.IMPORTANCE_HIGH);
            long[] pattern= {0, 1000, 1000, 1000};
            notificationChannel.setVibrationPattern(pattern);
            AudioAttributes audio= new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION).build();
            notificationChannel.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, audio);
            notificationManager.createNotificationChannel(notificationChannel);

        }

        notificationManager.notify(id_notifbuilder, builder.build());
        animation= AnimationUtils.loadAnimation(this,R.anim.splashanim);
        appname=findViewById(R.id.tv);
        lottieAnimationView=findViewById(R.id.splash);
        appname.setAnimation(animation);
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        },2500L);
    }
}