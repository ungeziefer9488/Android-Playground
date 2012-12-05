package com.example.StdDAOs;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: Falk Alexander
 * Date: 02.12.12
 * Time: 16:45
 */
public class SetRating extends BasicRating{
    protected String userId;

    public SetRating(String userId, double costPerformance, double taste, double quantity) {
        super(costPerformance, taste, quantity);
        this.userId = userId;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put("user_id", userId);
        jo.put("cost_performance", costPerformance);
        jo.put("quantity", quantity);
        jo.put("taste", taste);
        return jo;
    }
}
