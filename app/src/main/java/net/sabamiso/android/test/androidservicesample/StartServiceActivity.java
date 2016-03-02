package net.sabamiso.android.test.androidservicesample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class StartServiceActivity extends Activity {
    public static final String TAG = "StartServiceActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startService(new Intent(StartServiceActivity.this, MainService.class));
    }

    @Override
    protected void onPause() {
        stopService(new Intent(StartServiceActivity.this, MainService.class));
        super.onPause();
    }
}
