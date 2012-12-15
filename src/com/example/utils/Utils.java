package com.example.utils;


import com.example.StdDAOs.Meal;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Falk Alexander
 * Date: 29.11.12
 * Time: 08:33
 */
enum HttpVerbs {
    //TODO: Verify the Functions.
    GET("org.apache.http.client.methods.HttpGet"), POST("HttpPost"), PUT("HttpPut"), DELETE("HttpDelete");
    private String function;

    HttpVerbs(String function) {
        this.function = function;
    }

    public String getFunction() {
        return function;
    }
}
public class Utils {
    /**
     *
     * @param url
     * @param httpMethodName
     * @return
     * @throws IOException
     * @throws JSONException
     */
    public static JSONObject getJsonFromServer(String url, HttpVerbs httpMethodName) throws IOException, JSONException {
        // defaultHttpClient
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpReq = new HttpGet(url);
        //HttpUriRequest httpReq = (HttpUriRequest) Class.forName(httpMethodName.getFunction()).getConstructor(HttpUriRequest.class).newInstance(url);

        HttpResponse httpResponse = httpClient.execute(httpReq);
        BufferedReader reader;
        String json;
            reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            //TODO: The assumption is, that the json object is delivered in one line.
            json = reader.readLine();

        return new JSONObject(json);
    }

    /**
     *
     * @return
     * @throws IOException
     * @throws JSONException
     * @throws ServerFailureException
     */
    public static  JSONObject getJsonFromServer() throws  IOException, JSONException {
        return getJsonFromServer("http://192.168.0.12:8000/meals/", HttpVerbs.GET);
    }

    public static void postJsonToServer(String url, String entity) throws IOException, JSONException, ServerFailureException {
        // defaultHttpClient
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpReq = new HttpPost(url);
        //HttpUriRequest httpReq = (HttpUriRequest) Class.forName(httpMethodName.getFunction()).getConstructor(HttpUriRequest.class).newInstance(url);
        httpReq.setEntity(new StringEntity(entity));
        HttpResponse httpResponse = httpClient.execute(httpReq);
        BufferedReader reader;
        String json;
        reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
        //TODO: An assumption is, that the json object is delivered in one line.
        json = reader.readLine();

        JSONObject jo = new JSONObject(json);
        if (!jo.getBoolean("success")) {
            throw new ServerFailureException(jo.getString("error"));
        }
    }

    public static void postRating(String mealId, String entity) throws IOException, JSONException, ServerFailureException {
        postJsonToServer("http://192.168.0.12:8000/meals/"+mealId+"/", entity);
    }

    /**
     * TODO: Complete Description
     * TODO: Test me!
     * @param ja
     * @return
     * @throws JSONException
     */
    public static String[] getStringsFromJsonArray(JSONArray ja) throws JSONException {
        Vector<String> strings = new Vector<String>();
        for (int i = 0; i < ja.length(); i++) {
            strings.add(ja.getString(i));
        }
        String[] s = new String[strings.capacity()];
        s = strings.toArray(s);
        return s;
    }

    /**
     * TODO: Complete Description.
     * TODO: This method could be more generic for other use cases eg. single meal updates.
     * @return
     * @throws ServerFailureException
     */
    public static Meal[] fetchNewMeals() throws ServerFailureException, IOException, JSONException {
         Meal[] meals;
            JSONObject jo = getJsonFromServer();
            boolean success = jo.getBoolean("success");
            if (!success) {
                String error = jo.getString("error");
                throw new ServerFailureException(error);
            }
            meals = Meal.getMeals(jo.getJSONArray("meals"));
        return meals;
    }

    public static String[] parseJsonToStringArray(String toParse) {
        //TODO: Improve this! Write a regex that replaces everything with ine call. Or do something different.
        toParse = toParse.replaceAll("\"", "");
        toParse = toParse.replaceAll("]", "");
        toParse = toParse.replaceAll("\\[", "");
        return toParse.split(",");
    }
}
