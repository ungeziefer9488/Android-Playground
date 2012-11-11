package com.example.utils;

import com.example.DAOs.SendMealRating;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class PostMealRating {
    public static void main() {
        String mealId = "foobar";
        HttpHeaders requestHeaders = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://192.168.0.12:8000/meals/{mealId}/";
        SendMealRating smr = new SendMealRating(mealId, 1, 2, 3);
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SendMealRating> postrequestEntity = new HttpEntity<SendMealRating>(smr, requestHeaders);

        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());

        ResponseEntity responseEntity = restTemplate.exchange(url, HttpMethod.POST, postrequestEntity, null, mealId);
    }

}
