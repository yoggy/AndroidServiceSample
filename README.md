AndroidServiceSample
====

startService() / stopService()
----

    
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
    

bindService()
----

    
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
    


Copyright and license
----
Copyright (c) 2016 yoggy

Released under the [MIT license](LICENSE.txt)