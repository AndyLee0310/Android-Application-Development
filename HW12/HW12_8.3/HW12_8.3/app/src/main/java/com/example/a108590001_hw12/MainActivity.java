package com.example.a108590001_hw12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private static final int JOB_ID = 0;
    NotificationManager notify_manager;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createChannel();
    }

    public void download_Click(View view) {
        NotificationSend();
        JobScheduler mScer = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        ComponentName comptName = new ComponentName(getApplicationContext(), DownloadService.class.getName());
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, comptName);
        builder.setRequiresCharging(true)
                .setRequiresDeviceIdle(true)
                .setPeriodic(TimeUnit.DAYS.toMillis(1))
                .setRequiresDeviceIdle(true);
        if (Build.VERSION.SDK_INT > 23) {
            builder.setPeriodic(TimeUnit.DAYS.toMillis(1), TimeUnit.MINUTES.toMillis(5));
        }
        JobInfo jobInfo = builder.build();
        if (mScer != null) {
            mScer.schedule(jobInfo);
        }
    }

    private void createChannel() {
        notify_manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notification_channel = new NotificationChannel(PRIMARY_CHANNEL_ID, getResources().getString(R.string.ChannelName), NotificationManager.IMPORTANCE_HIGH);
            notification_channel.enableVibration(true);
            notification_channel.setDescription(getResources().getString(R.string.ChannelDesc));
            notification_channel.enableLights(true);
            notification_channel.setLightColor(Color.RED);
            notify_manager.createNotificationChannel(notification_channel);
        }
    }

    void NotificationSend() {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
                .setContentTitle(getResources().getString(R.string.notify_title))
                .setContentText(getResources().getString(R.string.notify_text))
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_download)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true);

        notify_manager.notify(0, builder.build());
    }

    public class DownloadService extends JobService {
        @Override
        public boolean onStartJob(JobParameters params) {
            NotificationSend();
            return false;
        }

        @Override
        public boolean onStopJob(JobParameters params) {
            return true;
        }
    }
}