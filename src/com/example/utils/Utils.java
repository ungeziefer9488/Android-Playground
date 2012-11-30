package com.example.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: falk
 * Date: 29.11.12
 * Time: 08:33
 * To change this template use File | Settings | File Templates.
 */
public class Utils {
    public void doIt() {
        String url = "";
        InputStream is;
        // defaultHttpClient
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpPost);
        } catch (Exception e) {

        }
        HttpEntity httpEntity = httpResponse.getEntity();
        try {
            is = httpEntity.getContent();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}
