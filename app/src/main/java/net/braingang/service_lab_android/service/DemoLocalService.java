package net.braingang.service_lab_android.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class DemoLocalService extends Service {
    public DemoLocalService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
