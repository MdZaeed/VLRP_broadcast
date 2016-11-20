package com.example.zayed.vlrp_braodcast;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class UpdaterServiceManager extends Service {

    public Context context;

    /*
        private final int UPDATE_INTERVAL = 60 * 1000;
    */
/*    private Timer timer = new Timer();
    private static final int NOTIFICATION_EX = 1;
    private NotificationManager notificationManager;*/

    public UpdaterServiceManager(Context context) {
        this.context = context;
    }

    public UpdaterServiceManager() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this, 0,
                notificationIntent, PendingIntent.FLAG_ONE_SHOT);

        Notification notification=new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("Service is running")
                .setContentIntent(pendingIntent).build();
        startForeground(1, notification);
        // Code to execute when the service is first created
        Log.d("Service Started","Yes");
    }

    @Override
    public void onDestroy() {
        Log.d("Service Destroyed","Yes");
        stopForeground(true);
        mStatusChecker=null;
        stopSelf();
    }

    Handler mHandler;
    LocationManager locationManager;
    LocationListener locationListener;

    @Override
    public int onStartCommand(Intent intent, int flags, int startid) {
/*        notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);*/
/*
        int icon = android.R.drawable.stat_notify_sync;
*/
/*        CharSequence tickerText = "Hello";
        long when = System.currentTimeMillis();
        Notification notification = new Notification(icon, tickerText, when);
        final Context context = getApplicationContext();
        CharSequence contentTitle = "My notification";
        CharSequence contentText = "Hello World!";*/
/*
        Intent notificationIntent = new Intent(this, Main.class);
*/
/*        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);*/
/*        notification.setLatestEventInfo(context, contentTitle, contentText,
                contentIntent);*/
/*
        notificationManager.notify(NOTIFICATION_EX, notification);
*/
        locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        locationListener = new MyLocationListener(getApplicationContext());
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(getApplicationContext(), "Please turn on your GPS!", Toast.LENGTH_LONG).show();
            return 0;
        }

        Toast.makeText(getApplicationContext(), "Started!", Toast.LENGTH_LONG).show();
/*        timer.scheduleAtFixedRate(new TimerTask(Looper.getMainLooper()) {

            @Override
            public void run() {
*//*
                Toast.makeText(context, "Continued!", Toast.LENGTH_LONG).show();
*//*
                Log.d("Timer Checking", "True");
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, locationListener);
                // Check if there are updates here and notify if true
            }
        }, 0, 10000);*/

        mHandler=new Handler(Looper.getMainLooper());

        mStatusChecker.run();

        return START_NOT_STICKY;
    }

    Runnable mStatusChecker = new Runnable() {
        @Override
        public void run() {
            try {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                Log.d("Running","Yes");
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 20000, 10, locationListener);
            } finally {
                // 100% guarantee that this always happens, even if
                // your update method throws an exception
                mHandler.postDelayed(mStatusChecker, 20000);
            }
        }
    };

    @Override
    public boolean stopService(Intent name) {
        Log.d("Service Stopped","Yes");
        return super.stopService(name);
    }
}