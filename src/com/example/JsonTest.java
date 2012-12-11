package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.example.StdDAOs.Meal;
import com.example.StdDAOs.SetRating;
import com.example.utils.ServerFailureException;
import com.example.utils.Utils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * User: Falk Alexander
 * Date: 28.11.12
 * Time: 09:55
 */
public class JsonTest extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String mealId = "36fa12fb5c53e40b36b129e7a962fa9e539f99e47aaee4ed78ca7c45e87d127f";
        SetRating sr = new SetRating(mealId, 1, 2, 3);
        try {
            Utils.postRating(mealId, sr.toJson().toString());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ServerFailureException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        /*JSONObject jo;
        try {
            jo = Utils.getJsonFromServer();
            Meal[] meals = Utils.fetchNewMeals();
            for (Meal m : meals) {
                Log.e("meal", m.toString());
            }
        } catch (ServerFailureException e) {
            //TODO: This is a error the user might be interested in.
            Log.e("some failure at the server", e.getMessage());
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }*/
    }
}