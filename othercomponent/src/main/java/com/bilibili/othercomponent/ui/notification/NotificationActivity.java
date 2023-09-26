package com.bilibili.othercomponent.ui.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.bilibili.othercomponent.R;
import com.bilibili.othercomponent.ui.activity.MainActivity;

public class NotificationActivity extends AppCompatActivity {

    private View tv_normal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_notification);

        tv_normal = findViewById(R.id.tv_normal);
        tv_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNormalNotification();
            }
        });
    }

    private void showNormalNotification() {
        Notification.Builder builder = new Notification.Builder(NotificationActivity.this)
                .setSmallIcon(R.drawable.record)
                .setContentTitle("消息")
                .setContentText("消息内容")
                .setTicker("你有新的消息")
                .setNumber(10)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.record))
                .setAutoCancel(true);

        Intent intent = new Intent(NotificationActivity.this, ResultActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(NotificationActivity.this
                , 0
                , intent
                , PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
    }
}
