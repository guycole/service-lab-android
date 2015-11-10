package net.braingang.service_lab_android.utility;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import net.braingang.service_lab_android.service.AlarmReceiver;

/**
 *
 */
public class ServiceLabApplication extends Application {
    public static final String LOG_TAG = ServiceLabApplication.class.getName();

    @Override
    public void onCreate() {
        Log.i(LOG_TAG, "xoxoxoxoxoxoxoxoxoxoxoxxoxoxoxoxoxo");
        Log.i(LOG_TAG, "xo start start start start start xo");
        Log.i(LOG_TAG, "xoxoxoxoxoxoxoxoxoxoxoxxoxoxoxoxoxo");

        startAlarmReceiver(this);
    }

    private void startAlarmReceiver(Context context) {
        ComponentName name = new ComponentName(context, AlarmReceiver.class);

        PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(name, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
    }
}
