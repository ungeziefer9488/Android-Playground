package com.example.StdDAOs;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Falk Alexander
 * Date: 01.12.12
 * Time: 10:57
 * To change this template use File | Settings | File Templates.
 */
public class BasicRating {
    protected Double costPerformance;
    protected Double taste;
    protected Double quantity;

    public BasicRating(double costPerformance, double taste, double quantity) {
        this.costPerformance = costPerformance;
        this.taste = taste;
        this.quantity = quantity;
    }

    public Double getCostPerformance() {
        return costPerformance;
    }

    public void setCostPerformance(Double costPerformance) {
        this.costPerformance = costPerformance;
    }

    public Double getTaste() {
        return taste;
    }

    public void setTaste(Double taste) {
        this.taste = taste;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public static BasicRating fromJson(JSONObject jo) throws JSONException {
            return new BasicRating(jo.getDouble("cost_performance"), jo.getDouble("taste"), jo.getDouble("quantity"));
    }

    public static BasicRating fromJson(String json) throws JSONException {
        return fromJson(new JSONObject(json));
    }
}
