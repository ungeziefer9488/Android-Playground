package com.example.utils;


import com.example.StdDAOs.Meal;
import org.apache.http.HttpResponse;
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
 * User: falk
 * Date: 29.11.12
 * Time: 08:33
 * To change this template use File | Settings | File Templates.
 */
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
    public static JSONObject getJsonFromServer(String url, String httpMethodName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, IOException, JSONException {
        // defaultHttpClient
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpUriRequest httpReq = (HttpUriRequest) Class.forName(httpMethodName).getConstructor(String.class).newInstance(url);

        HttpResponse httpResponse = httpClient.execute(httpReq);
        BufferedReader reader;
        String json = null;
            reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            //TODO: The assumption is, that the json object is delivered in one line.
            json = reader.readLine();

        return new JSONObject(json);
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
        return getJsonFromServer("192.168.0.12:8000/meals/", "HttpGet");
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
        return (String[]) strings.toArray();
    }

    /**
     * TODO: Complete Description.
     * TODO: This method could be more generic for other use cases eg. single meal updates.
     * @return
     * @throws ServerFailureException
     */
    public static Meal[] fetchNewMeals() throws ServerFailureException {
         Meal[] meals;
        try {
            JSONObject jo = getJsonFromServer();
            boolean success = jo.getBoolean("success");
            if (!success) {
                String error = jo.getString("error");
                //TODO: This looks like bad style. There is room for improvement!
                throw new ServerFailureException(error);
            }
            meals = Meal.getMeals(jo.getJSONArray("meals"));
        } catch (Exception e) {
            throw new ServerFailureException(e.getMessage());
        }
        return meals;
    }
}
