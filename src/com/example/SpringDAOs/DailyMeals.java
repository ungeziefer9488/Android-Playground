package com.example.SpringDAOs;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Ungeziefer
 * Date: 04.11.12
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 */
public class DailyMeals {
    private String date;
    private Meal[] meal;

    public DailyMeals(@JsonProperty("date") String date, @JsonProperty("meal") Meal[] meal) {

        this.date = date;
        this.meal = meal;
    }

    @Override
    public String toString() {
        return "DailyMeals{" +
                "date='" + date + '\'' +
                ", meal=" + (meal == null ? null : Arrays.asList(meal)) +
                '}';
    }
}
