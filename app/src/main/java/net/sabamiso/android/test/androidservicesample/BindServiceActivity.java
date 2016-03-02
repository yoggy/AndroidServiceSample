package net.sabamiso.android.test.androidservicesample;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Bundle;
import android.util.Log;

public class BindServiceActivity extends Activity {
    public static final String TAG = "BindServiceActivity";

    MainService mainService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(this, MainService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        Intent intent = new Intent(this, MainService.class);
        unbindService(serviceConnection);
        super.onPause();
    }

    ServiceConnection serviceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            Log.d(TAG, "onServiceConnected()");
            // bindServiceの場合、Binderを通じて、直接MainServiceのインスタンスを得ることができる
            mainService = ((MainService.MainServiceBinder)binder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected()");
            mainService = null;
        }
    };
}
