package com.example;

import android.app.Activity;
import android.os.Bundle;
import org.springframework.web.client.RestTemplate;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        RestTemplate restTemplate = new RestTemplate();
    }
}
