package com.example;

import android.app.Activity;
import android.os.Bundle;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Test");
        setContentView(R.layout.main);
    }
}
                             /* RestTemplate restTemplate = new RestTemplate(true);
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        final String url = "http://192.168.178.89/rest/dummy.json";
        System.out.print(url);
       // List<HttpMessageConverter> l = new ArrayList<HttpMessageConverter>();
       //l.add(new MappingJacksonHttpMessageConverter());
        //restTemplate.setMessageConverters((List<HttpMessageConverter<?>>) l);
           // Dummy dummy = restTemplate.getForObject(url, Dummy.class);

        //System.out.print(dummies.getDummies()[0].getName());*/