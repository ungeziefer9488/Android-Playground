package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.example.DAOs.Meal;
import com.example.DAOs.Mensa;
import org.codehaus.jackson.map.DeserializationConfig;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);				// The URL for making the GET request
        final String url = "http://141.82.160.130:8000/update/";

        // Set the Accept header for "application/json"
        HttpHeaders requestHeaders = new HttpHeaders();
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(acceptableMediaTypes);

        // Populate the headers in an HttpEntity object to use for the request
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

        // Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();
        MappingJacksonHttpMessageConverter m = new MappingJacksonHttpMessageConverter();
        m.getObjectMapper().configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        restTemplate.getMessageConverters().add(m);

        // Perform the HTTP GET request
        //DailyMeals[] mm = restTemplate.getForObject(url, DailyMeals[].class);
       ResponseEntity<Mensa> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
                Mensa.class);
        //Log.v("test-Tag", "this is a test message");
        //Dummy dummy = restTemplate.getForObject(url, Dummy.class);

       Log.e("debug content",responseEntity.getBody().toString());

        // Create and populate a simple object to be used in the request
        Meal meal = null;

// Set the Content-Type header
        HttpHeaders PorstrequestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application","json"));
        HttpEntity<Meal> postrequestEntity = new HttpEntity<Meal>(meal, requestHeaders);

// Create a new RestTemplate instance
        RestTemplate postrestTemplate = new RestTemplate();

// Add the Jackson and String message converters
        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

// Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        ResponseEntity<String> postresponseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        setContentView(R.layout.main);
    }
}