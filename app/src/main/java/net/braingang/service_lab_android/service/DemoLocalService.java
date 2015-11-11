package net.braingang.service_lab_android.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class DemoLocalService extends Service {
    public static final String LOG_TAG = DemoLocalService.class.getName();

    public static final String EXTRA_PARAM1 = "net.braingang.service_lab_android.service.extra.PARAM1";

    public DemoLocalService() {
        //empty
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "onCreate entry");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy entry");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        final String action = intent.getAction();
        final String extra = intent.getStringExtra(EXTRA_PARAM1);

        Log.d(LOG_TAG, "onStart:" + action + ":" + extra);

        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
