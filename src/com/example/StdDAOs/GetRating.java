package com.example.StdDAOs;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Falk Alexander
 * Date: 01.12.12
 * Time: 11:16
 */

/**
 * GetRating has a date otherwise than SetRating. This has a mealId.
 */
public class GetRating extends BasicRating {
    protected String date;
    public GetRating(String date, Double costPerformance, Double taste, Double quantity) {
        super(costPerformance, taste, quantity);
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static GetRating[] getRatings(JSONArray ja) throws JSONException {
        ArrayList<GetRating> getRatings = new ArrayList<GetRating>();
        for (int i = 0; i < ja.length(); i++) {
            JSONObject jo = ja.getJSONObject(i);
            getRatings.add(new GetRating(jo.getString("date"), jo.getDouble("cost_performance"), jo.getDouble("taste"), jo.getDouble("quantity")));
        }
        GetRating[] gr = new GetRating[getRatings.size()];
        gr = getRatings.toArray(gr);
        return gr;
    }

    public static GetRating[] getRatings(String json) throws JSONException {
        JSONArray ja = new JSONArray(json);
        return getRatings(ja);
    }

    @Override
    public String toString() {
        return "GetRating{" +
                "date='" + date + '\'' +
                "} " + super.toString();
    }
}
