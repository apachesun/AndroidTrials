package com.github.apachesun.launcherworkflow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.apachesun.launcherworkflow.data.LauncherData;

public class LauncherActivity extends AppCompatActivity {
    private final String TAG_LAUNCHER = "LAUNCHER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (LauncherData.isSplashDisplayed(LauncherActivity.this) == false) {
            Intent intent = new Intent(this, SplashActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        super.onCreate(savedInstanceState);
        Log.i(TAG_LAUNCHER, "launcher activity finished.");
        finish();
    }
}
