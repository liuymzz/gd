package com.lym.gd.utils;


import com.google.gson.Gson;

/**
 * @author liuyaming
 * @date 2018/3/12 下午8:15
 */
public class JsonUtil {
    private static Gson gson = new Gson();

    public static String toJson(Object object){
        return gson.toJson(object);
    }

    public static<T> T fromJson(String jsonString,Class<T> classType){
        return gson.fromJson(jsonString,classType);
    }

}
