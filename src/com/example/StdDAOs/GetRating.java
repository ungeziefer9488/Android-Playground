package com.example.StdDAOs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Ungeziefer
 * Date: 01.12.12
 * Time: 11:16
 * To change this template use File | Settings | File Templates.
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
        Vector<GetRating> getRatings = new Vector<GetRating>();
        for (int i = 0; i < ja.length(); i++) {
            JSONObject jo = ja.getJSONObject(i);
            getRatings.add(new GetRating(jo.getString("date"), jo.getDouble("cost_performance"), jo.getDouble("taste"), jo.getDouble("quantity")));
        }
        return (GetRating[]) getRatings.toArray();
    }

    public static GetRating[] getRatings(String json) throws JSONException {
        JSONArray ja = new JSONArray(json);
        return getRatings(ja);
    }
}
