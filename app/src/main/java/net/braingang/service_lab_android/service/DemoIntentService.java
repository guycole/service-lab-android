package net.braingang.service_lab_android.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

public class DemoIntentService extends IntentService {
    public static final String LOG_TAG = DemoIntentService.class.getName();

    public static final String EXTRA_PARAM1 = "net.braingang.service_lab_android.service.extra.PARAM1";

    /**
     *
     * @param context
     * @param param1
     */
    public static void startAction(Context context, String param1) {
        Intent intent = new Intent(context, DemoIntentService.class);
        intent.putExtra(EXTRA_PARAM1, param1);
        context.startService(intent);
    }

    public DemoIntentService() {
        super("DemoIntentService");
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
    protected void onHandleIntent(Intent intent) {
        if (intent == null) {
            Log.d(LOG_TAG, "onHandleIntent w/null intent");
        } else {
            final String param1 = intent.getStringExtra(EXTRA_PARAM1);
            Log.d(LOG_TAG, "onHandleIntent:" + param1);
        }
    }
}
