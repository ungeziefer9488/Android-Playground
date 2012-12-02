package com.example.utils;


import com.example.StdDAOs.Meal;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: falk
 * Date: 29.11.12
 * Time: 08:33
 * To change this template use File | Settings | File Templates.
 */
public class Utils {
    /**
     * TODO: Correct handling of exceptions. Just printing the stack is not enough.
     */
    public static String getJsonFromServer(String url, String httpMethodName) throws Exception {
        // defaultHttpClient
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpUriRequest httpReq = (HttpUriRequest) Class.forName(httpMethodName).getConstructor(String.class).newInstance(url);

        HttpResponse httpResponse = httpClient.execute(httpReq);
        assert(httpResponse != null);
        BufferedReader reader;
        String json = null;
        try {
            reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            json = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    public static  String getJsonFromServer() throws Exception {
        return getJsonFromServer("192.168.0.12:8000/meals", "HttpGet");
    }

    public static String[] getStringsFromJsonArray(JSONArray ja) throws JSONException {
        Vector<String> strings = new Vector<String>();
        for (int i = 0; i < ja.length(); i++) {
            strings.add(ja.getString(i));
        }
        return (String[]) strings.toArray();
    }
}
