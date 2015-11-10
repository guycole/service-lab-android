package net.braingang.service_lab_android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import net.braingang.service_lab_android.utility.AlarmHelper;

public class AlarmReceiver extends BroadcastReceiver {
    public static final String LOG_TAG = AlarmReceiver.class.getName();

    public static final String ACTION_REPEATING_ALARM = "net.braingang.service_lab_android.REPEATING_ALARM";

    private final AlarmHelper _alarmHelper = new AlarmHelper();

    public AlarmReceiver() {
        //empty
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() == null) {
            Log.d(LOG_TAG, "RX RX RX:null action");
        } else {
            Log.d(LOG_TAG, "RX RX RX: " + intent.getAction());

            if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
                Log.d(LOG_TAG, "boot noted");

                _alarmHelper.startAlarm(context);
            }
        }
    }
}
