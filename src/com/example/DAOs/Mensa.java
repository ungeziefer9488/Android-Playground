package com.example.DAOs;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: Ungeziefer
 * Date: 04.11.12
 * Time: 13:58
 * To change this template use File | Settings | File Templates.
 */
public class Mensa {
    private GlobalMensaMenu menu;

    public Mensa(@JsonProperty("mensa")GlobalMensaMenu mensaMenu) {
        this.menu = mensaMenu;
    }

    public Mensa() {
    }

    @Override

    public String toString() {
        return "Mensa{" +
                "menu=" + menu +
                '}';
    }
}
