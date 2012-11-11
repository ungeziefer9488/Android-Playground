package com.example.utils;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.lang.String.*;

/**
 * Created with IntelliJ IDEA.
 * User: Ungeziefer
 * Date: 10.11.12
 * Time: 09:46
 * To change this template use File | Settings | File Templates.
 */
public class CryptoUtils {
    public static String stringToHash(String message, String hashType) throws NoSuchAlgorithmException {
        MessageDigest digester = MessageDigest.getInstance(hashType);
        try {
            digester.update(message.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            Log.e("CryptoUtils:", e.getMessage());
        }
        byte[] data = digester.digest();
        return format("%0" + (data.length * 2) + "X", new BigInteger(1, data));
    }

    public static String stringToSHA256(String message) throws NoSuchAlgorithmException {
        return stringToHash(message, "SHA-256");
    }
}
