package edu.sunyulster.serviceexample;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends JobIntentService {

    public static final String TAG = "MyIntentService";
    public static final int TEN_SECONDS = 10_000;

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        Log.i(TAG, "JobIntentService started");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(TEN_SECONDS);
            } catch (InterruptedException e) {}
            Log.i(TAG, "JobIntentService running: Iteration " + (i + 1));
        }
    }
}
