package com.example.DAOs;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created with IntelliJ IDEA.
 * User: Ungeziefer
 * Date: 27.10.12
 * Time: 11:20
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dummies {
    private Dummy[] dummies;

    public Dummy[] getDummies() {
        return dummies;
    }

    public void setDummies(Dummy[] dummies) {
        this.dummies = dummies;
    }

    public Dummies(Dummy[] dummies) {
        this.dummies = dummies;
    }
}
