package com.example.utils;

/**
 * Created with IntelliJ IDEA.
 * User: Ungeziefer
 * Date: 02.12.12
 * Time: 18:09
 * To change this template use File | Settings | File Templates.
 */
public class ServerFailureException extends Exception {
    public ServerFailureException(String error) {
        super(error);
    }
}
