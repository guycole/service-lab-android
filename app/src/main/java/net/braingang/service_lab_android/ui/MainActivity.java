package net.braingang.service_lab_android.ui;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import net.braingang.service_lab_android.R;
import net.braingang.service_lab_android.service.DemoIntentService;
import net.braingang.service_lab_android.service.DemoLocalService;
import net.braingang.service_lab_android.utility.AlarmHelper;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG = MainActivity.class.getName();

    private final AlarmHelper _alarmHelper = new AlarmHelper();

    private PendingIntent _pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button start = (Button) findViewById(R.id.buttonStart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LOG_TAG, "start alarm");
                _pendingIntent = _alarmHelper.startAlarm(getBaseContext());
            }
        });

        Button stop = (Button) findViewById(R.id.buttonStop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LOG_TAG, "stop alarm");
                _alarmHelper.stopAlarm(_pendingIntent, getBaseContext());
            }
        });

        Button intentService = (Button) findViewById(R.id.buttonIntentService);
        intentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LOG_TAG, "start intent service");
                for (int ii = 0; ii < 10; ii++) {
                    DemoIntentService.startAction(getBaseContext(), Integer.toString(ii));
                }
            }
        });

        Button localService = (Button) findViewById(R.id.buttonLocalService);
        localService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LOG_TAG, "start local service");
                for (int ii = 0; ii < 10; ii++) {
                    Intent intent = new Intent(getBaseContext(), DemoLocalService.class);
                    intent.setAction("test");
                    intent.putExtra(DemoLocalService.EXTRA_PARAM1, Integer.toString(ii));

                    startService(intent);
                    //DemoIntentService.startAction(getBaseContext(), Integer.toString(ii));
                }
            }
        });
    }
}
