package com.example.utils;

/**
 * Created with IntelliJ IDEA.
 * User: Falk Alexander
 * Date: 02.12.12
 * Time: 18:09
 *
 * This exception is raised when the server returns a json object
 * "success":false with a error message in "error":"some message".
 */
public class ServerFailureException extends Exception {
    public ServerFailureException(String error) {
        super(error);
    }
}
