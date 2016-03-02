package net.sabamiso.android.test.androidservicesample;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MainService extends Service {
    public static final String TAG = "MainService";

    public class MainServiceBinder extends Binder {
        public MainService getService() {
            return MainService.this;
        }
    }
    MainServiceBinder binder = new MainServiceBinder();

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind() : intent=" + intent);
        return binder;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate()");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() : intent=" + intent + ", flags=" + flags + ", startId=" + startId);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy()");
        super.onDestroy();
    }
}
