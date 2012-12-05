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
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws IOException
     * @throws JSONException
     */
    public static JSONObject getJsonFromServer(String url, HttpVerbs httpMethodName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, IOException, JSONException {
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

    public static void postJsonToServer(String url) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, IOException, JSONException, ServerFailureException {
        // defaultHttpClient
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpReq = new HttpPost(url);
        //HttpUriRequest httpReq = (HttpUriRequest) Class.forName(httpMethodName.getFunction()).getConstructor(HttpUriRequest.class).newInstance(url);
        //TODO: Set the content of the POST Method.
        HttpResponse httpResponse = httpClient.execute(httpReq);
        BufferedReader reader;
        String json;
        reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
        //TODO: The assumption is, that the json object is delivered in one line.
        json = reader.readLine();

        JSONObject jo = new JSONObject(json);
        if (!jo.getBoolean("success")) {
            throw new ServerFailureException(jo.getString("error"));
        }
    }

    /**
     *
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws IOException
     * @throws JSONException
     */
    public static  JSONObject getJsonFromServer() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, IOException, JSONException {
        return getJsonFromServer("http://192.168.0.12:8000/meals/", HttpVerbs.GET);
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
    public static Meal[] fetchNewMeals() throws ServerFailureException {
         Meal[] meals = new Meal[0];
        try {
            JSONObject jo = getJsonFromServer();
            boolean success = jo.getBoolean("success");
            if (!success) {
                String error = jo.getString("error");
                //TODO: This looks like bad style. There is room for improvement!
                throw new ServerFailureException(error);
            }
            meals = Meal.getMeals(jo.getJSONArray("meals"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return meals;
    }

    public static String[] parseJsonToStringArray(String toParse) {
        //TODO: Improve this!
        toParse = toParse.replaceAll("\"", "");
        toParse = toParse.replaceAll("]", "");
        toParse = toParse.replaceAll("\\[", "");
        return toParse.split(",");
    }
}
