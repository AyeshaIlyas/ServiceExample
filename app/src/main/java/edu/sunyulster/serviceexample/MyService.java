package edu.sunyulster.serviceexample;

import android.util.Log;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

    public static final String TAG = "MyService";
    public static final int TEN_SECONDS = 10_000;
    public static final String NAME = "Ayesha Ilyas";

    @Override
    public void onCreate() {
        Log.i(TAG, "Service created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Service onStartCommand " + startId);

        Runnable runnable = () -> {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(TEN_SECONDS);
                    Log.i(TAG, String.format("%s's Service %d running: Time running -> %ds",
                            NAME, startId, (TEN_SECONDS  * (i + 1)) / 1_000));
                } catch (InterruptedException e) {}
            }
        };
        Thread service = new Thread(runnable);
        service.start();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "Service onBind");
        return null;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "Service onDestroy");
    }


}
