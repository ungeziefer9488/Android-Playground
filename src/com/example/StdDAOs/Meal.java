package com.example.StdDAOs;

import android.util.Log;
import com.example.utils.Utils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Falk Alexander
 * Date: 29.11.12
 * Time: 09:32
 */
public class Meal {
    private GetRating[] ratings;
    private String[] date;
    private String name;
    private Map<String, Double> prices;
    private String mealId;
    private String[] additives;
    //TODO: IMO getting the keys of the prices can be fully generic.
    public static String[] priceTypes = {"student", "normal"};

    public Meal(GetRating[] ratings, String[] date, String name, Map<String, Double> prices, String mealId, String[] additives) {
        this.ratings = ratings;
        this.date = date;
        this.name = name;
        this.prices = prices;
        this.mealId = mealId;
        this.additives = additives;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "ratings=" + (ratings == null ? null : Arrays.asList(ratings)) +
                ", date=" + (date == null ? null : Arrays.asList(date)) +
                ", name='" + name + '\'' +
                ", prices=" + prices +
                ", mealId='" + mealId + '\'' +
                ", additives=" + (additives == null ? null : Arrays.asList(additives)) +
                '}';
    }

    public GetRating[] getRatings() {
        return ratings;
    }

    public void setRatings(GetRating[] ratings) {
        this.ratings = ratings;
    }

    public String[] getDate() {
        return date;
    }

    public void setDate(String[] date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Double> getPrices() {
        return prices;
    }

    public void setPrices(Map<String, Double> prices) {
        this.prices = prices;
    }

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public String[] getAdditives() {
        return additives;
    }

    public void setAdditives(String[] additives) {
        this.additives = additives;
    }

    public static Meal[] getMeals(JSONArray ja) throws JSONException {
        JSONObject jo;
        ArrayList<Meal> meals = new ArrayList<Meal>();
        for (int i = 0; i < ja.length(); i++) {
            jo = ja.getJSONObject(i);
            meals.add(new Meal(GetRating.getRatings(jo.getJSONArray("ratings")),
                    Utils.parseJsonToStringArray(jo.getString("date")),
                    jo.getString("name"), Meal.getPrice(jo.getJSONObject("price")),
                    jo.getString("meal_id"),
                    Utils.parseJsonToStringArray(jo.getString("additives"))));
            Log.e("additives", Utils.parseJsonToStringArray(jo.getString("additives"))[0]);
        }
        Meal[] m = new Meal[meals.size()];
        m = meals.toArray(m);
        return m;
    }

    public static Map<String, Double> getPrice(JSONObject jo) throws JSONException {
        Map<String, Double> price = new HashMap<String, Double>();
        for (String type : priceTypes) {
            price.put(type, jo.getDouble(type));
        }
        return price;
    }
}
