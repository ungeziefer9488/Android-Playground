package com.example.StdDAOs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Falk Alexander
 * Date: 01.12.12
 * Time: 11:30
 */
enum RatingFormat {
    LONG, SHORT;
}

/**
 * This rating is given by ratings/userId/...
 */
public class SpecificRating {
    RatingFormat ratingFormat;
    GetRating[] own;
    GetRating[] other;

    public SpecificRating(RatingFormat ratingFormat, GetRating[] own, GetRating[] other) {
        this.ratingFormat = ratingFormat;
        this.own = own;
        this.other = other;
    }

    public SpecificRating(RatingFormat ratingFormat, String json) throws JSONException {
        JSONObject jo = new JSONObject(json);
        this.ratingFormat = ratingFormat;
        this.own = GetRating.getRatings(jo.getString("own"));
        this.other = GetRating.getRatings(jo.getString("other"));
    }

    public RatingFormat getRatingFormat() {
        return ratingFormat;
    }

    public void setRatingFormat(RatingFormat ratingFormat) {
        this.ratingFormat = ratingFormat;
    }

    public GetRating[] getOwn() {
        return own;
    }

    public void setOwn(GetRating[] own) {
        this.own = own;
    }

    public GetRating[] getOther() {
        return other;
    }

    public void setOther(GetRating[] other) {
        this.other = other;
    }

}
