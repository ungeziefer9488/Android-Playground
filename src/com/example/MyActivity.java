package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import org.codehaus.jackson.annotate.JacksonAnnotation;
import org.codehaus.jackson.map.DeserializationConfig;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);				// The URL for making the GET request
        final String url = "http://192.168.0.12/rest/mensa.json";

        // Set the Accept header for "application/json"
        HttpHeaders requestHeaders = new HttpHeaders();
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        //acceptableMediaTypes.add(new MediaType("text", "htm", Charset.forName("utf-8")));
        //acceptableMediaTypes.add(new MediaType("text", "plain"));
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
        //MensaMenu[] mm = restTemplate.getForObject(url, MensaMenu[].class);
       ResponseEntity<Mensa> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
                Mensa.class);
        //Log.v("test-Tag", "this is a test message");
        //Dummy dummy = restTemplate.getForObject(url, Dummy.class);

        Log.e("debug content",responseEntity.getBody().toString());
        setContentView(R.layout.main);
    }
}