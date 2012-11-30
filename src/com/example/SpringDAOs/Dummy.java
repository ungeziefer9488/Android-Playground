package com.example.SpringDAOs;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: Ungeziefer
 * Date: 27.10.12
 * Time: 11:18
 * To change this template use File | Settings | File Templates.
 */

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Dummy {
    public Dummy() {
    }

    @JsonProperty

    private String id;
    @JsonProperty
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dummy{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dummy(String id, String name) {

        this.id = id;
        this.name = name;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
