package com.example.zayed.vlrp_braodcast;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    UpdaterServiceManager updaterServiceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view) {
        if(isMyServiceRunning(UpdaterServiceManager.class))
        {
            updaterServiceManager=new UpdaterServiceManager(this);
            Intent intent=new Intent(this,updaterServiceManager.getClass());
            stopService(intent);
        }
        updaterServiceManager=new UpdaterServiceManager(this);
        Intent intent=new Intent(this,updaterServiceManager.getClass());
        startService(intent);
    }

    public void stop(View view) {
        if(isMyServiceRunning(UpdaterServiceManager.class))
        {
            updaterServiceManager=new UpdaterServiceManager(this);
            Intent intent=new Intent(this,UpdaterServiceManager.class);
            stopService(intent);
        }
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
