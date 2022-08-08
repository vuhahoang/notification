package com.example.notificationtest;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             sendnotification();
                Log.e("havu","tai sao k chạy");
            }
        });
    }

    private int getNotificationId(){
        return (int) new Date().getTime();
    }



    public void putnotification(){
        @SuppressLint("RemoteViewLayout")
        RemoteViews notificationLayout = new RemoteViews(getPackageName(), R.layout.notification_layout);

        notificationLayout.setImageViewResource(R.id.imgMovie,R.drawable.thor);
        notificationLayout.setTextViewText(R.id.tvnametitleNoti,"Thor Tình yêu và Sấm sét");

// Apply the layouts to the notification
        Notification customNotification = new NotificationCompat.Builder(this, Aplication.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_next)
                .setCustomContentView(notificationLayout)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(getNotificationId(),customNotification);
    }

    public void sendnotification(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
    Notification notification = new Notification.Builder(this)
            .setContentTitle("Title push notification")
            .setContentText("Message push notification")
            .setSmallIcon(R.drawable.ic_play)
            .setLargeIcon(bitmap)
            .build();

    NotificationManager notificationManager = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
    if(notificationManager != null){
        notificationManager.notify(1,notification);
    }




    }

}