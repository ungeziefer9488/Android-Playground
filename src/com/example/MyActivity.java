package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);				// The URL for making the GET request
        final String url = "http://192.168.178.89/rest/dummy.json";

        // Set the Accept header for "application/json"
        HttpHeaders requestHeaders = new HttpHeaders();
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(acceptableMediaTypes);

        // Populate the headers in an HttpEntity object to use for the request
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

        // Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());

        // Perform the HTTP GET request
        ResponseEntity<Dummy> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
                Dummy.class);
        //Log.v("test-Tag", "this is a test message");
        //Dummy dummy = restTemplate.getForObject(url, Dummy.class);

        Log.e("debug content",responseEntity.getBody().toString());
        setContentView(R.layout.main);
    }
}