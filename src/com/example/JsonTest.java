package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.example.StdDAOs.Meal;
import com.example.utils.ServerFailureException;
import com.example.utils.Utils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: Falk Alexander
 * Date: 28.11.12
 * Time: 09:55
 * To change this template use File | Settings | File Templates.
 */
public class JsonTest extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JSONObject jo;
        try {
            jo = Utils.getJsonFromServer();
            Meal[] meals = Utils.fetchNewMeals();
        } catch (ServerFailureException e) {
            //TODO: This is a error the user might be interested in.
            Log.e("some failure at the server", e.getMessage());
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}