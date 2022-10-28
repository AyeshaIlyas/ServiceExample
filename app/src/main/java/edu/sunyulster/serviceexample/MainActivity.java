package edu.sunyulster.serviceexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import edu.sunyulster.serviceexample.databinding.ActivityMainBinding;
import android.view.View;
import android.content.Intent;
import androidx.core.app.JobIntentService;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding binding;
    public static final int SERVICE_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void startIntentService(View view) {
        Intent intent = new Intent();
        JobIntentService.enqueueWork(this, MyIntentService.class, SERVICE_ID, intent);
    }

    public void startService(View view) {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

}