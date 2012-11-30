package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.example.SpringDAOs.SendMealRating;
import com.example.utils.CryptoUtils;
import org.codehaus.jackson.map.DeserializationConfig;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);                // The URL for making the GET request
        String url = "http://192.168.0.12:8000/update/";

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
        //ResponseEntity<Mensa> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
        //        Mensa.class);
        //Log.v("test-Tag", "this is a test message");
        //Dummy dummy = restTemplate.getForObject(url, Dummy.class);

        //Log.e("debug content", responseEntity.getBody().toString());

        // Create and populate a simple object to be used in the request
        String mealId = null;
        try {
            mealId = CryptoUtils.stringToSHA256("Blumenkohl mit Hollandaise und K\\u00e4se \\u00fcberbacken");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        assert mealId != null;
        url = "http://192.168.0.12:8000/meals/{mealId}/";
        Log.e("meal string", url);
        SendMealRating smr = new SendMealRating(mealId, 1, 2, 3);
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SendMealRating> postrequestEntity = new HttpEntity<SendMealRating>(smr, requestHeaders);
        Log.e("meal json", postrequestEntity.getBody().toString());

// Add the Jackson and String message converters
        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

// Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        //String postresponseEntity = restTemplate.postForObject(url, smr, String.class);
        ResponseEntity responseEntity = restTemplate.exchange(url, HttpMethod.POST, postrequestEntity, null, mealId);
        //Log.e("post test", responseEntity.getBody().toString());
        setContentView(R.layout.main);
    }
}