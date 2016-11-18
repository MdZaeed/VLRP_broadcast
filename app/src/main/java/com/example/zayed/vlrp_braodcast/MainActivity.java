package com.example.zayed.vlrp_braodcast;

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
        updaterServiceManager=new UpdaterServiceManager(this);
        Intent intent=new Intent(this,updaterServiceManager.getClass());
        startService(intent);
    }

    public void stop(View view) {
        updaterServiceManager.stopService();
    }
}
