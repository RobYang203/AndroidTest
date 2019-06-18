package dev4.mts.notification;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnNotify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init(){
        btnNotify = (Button)findViewById(R.id.btnNotify);

        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = "channel_1";
                String description ="test";
                int importanceLevel = NotificationManager.IMPORTANCE_LOW;
                NotificationChannel channel = new NotificationChannel(id,"123",importanceLevel);

                NotificationManager NM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                NM.createNotificationChannel(channel);

                Notification notification = new NotificationCompat.Builder(MainActivity.this,id)
                        .setCategory(Notification.CATEGORY_MESSAGE)
                        .setContentTitle("123")
                        .setContentText("156")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setWhen(System.currentTimeMillis())
                        .build();
                NM.notify(1,notification);
            }
        });

    }
}
