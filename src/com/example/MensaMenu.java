package com.example;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Arrays;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Ungeziefer
 * Date: 04.11.12
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 */
public class MensaMenu {
    private String date;
    private Meal[] meal;

    public MensaMenu(@JsonProperty("date") String date, @JsonProperty("meal") Meal[] meal) {

        this.date = date;
        this.meal = meal;
    }

    @Override
    public String toString() {
        return "MensaMenu{" +
                "date='" + date + '\'' +
                ", meal=" + (meal == null ? null : Arrays.asList(meal)) +
                '}';
    }
}
