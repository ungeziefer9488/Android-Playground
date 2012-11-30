package com.example.SpringDAOs;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Arrays;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Ungeziefer
 * Date: 04.11.12
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 */
public class Meal {
    private String name;
    private String[] additive;
    private String campaign;
    private Map<String, Float> price;

    @Override
    public String toString() {
        return "Meal{" +
                "name='" + name + '\'' +
                ", additive=" + (additive == null ? null : Arrays.asList(additive)) +
                ", campaign='" + campaign + '\'' +
                ", price=" + price +
                '}';
    }

    public Meal(@JsonProperty("name") String name, @JsonProperty("additive") String[] additive, @JsonProperty("campaign") String campaign, @JsonProperty("price") Map<String, Float> price) {
        this.name = name;
        this.additive = additive;
        this.campaign = campaign;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAdditive() {
        return additive;
    }

    public void setAdditive(String[] additive) {
        this.additive = additive;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public Map<String, Float> getPrice() {
        return price;
    }

    public void setPrice(Map<String, Float> price) {
        this.price = price;
    }
}
