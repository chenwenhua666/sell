package com.plm.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * chenwenhua
 * 2018\10\23 0023
 * 21:17
 */
public class JsonUtil {
    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
