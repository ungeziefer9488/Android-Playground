package com.example;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Ungeziefer
 * Date: 04.11.12
 * Time: 19:10
 * To change this template use File | Settings | File Templates.
 */
public class GlobalMensaMenu {
    private DailyMeals[] mensaMenus;

    public GlobalMensaMenu(@JsonProperty("menu") DailyMeals[] mensaMenus) {
        this.mensaMenus = mensaMenus;
    }

    @Override
    public String toString() {
        return "GlobalMensaMenu{" +
                "mensaMenus=" + (mensaMenus == null ? null : Arrays.asList(mensaMenus)) +
                '}';
    }
}
