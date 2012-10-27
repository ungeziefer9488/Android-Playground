package com.example;

/**
 * Created with IntelliJ IDEA.
 * User: Ungeziefer
 * Date: 27.10.12
 * Time: 11:18
 * To change this template use File | Settings | File Templates.
 */

public class Dummy {
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dummy(int id, String name) {

        this.id = id;
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
