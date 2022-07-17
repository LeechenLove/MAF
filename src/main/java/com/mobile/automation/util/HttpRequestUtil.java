package com.mobile.automation.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

public class HttpRequestUtil {

    private static final Logger log = LoggerFactory.getLogger(HttpRequestUtil.class);
    private static final String schemeValue = "http";
    private static final String hostValue = "localhost";
    private static final String projectValue = "chat15-restful";
    private static final int portVale = 8080;
    private static OkHttpClient okHttpClient = new OkHttpClient();


    public static void parseJson(Object object) {
        if(object instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) object;
            for (Map.Entry<String, Object> entry: jsonObject.entrySet()) {
                Object o = entry.getValue();
                if(o instanceof String) {
                    System.out.println("key:" + entry.getKey() + "，value:" + entry.getValue());
                } else {
                    parseJson(o);
                }
            }
        }
        if(object instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) object;
            for(int i = 0; i < jsonArray.size(); i ++) {
                parseJson(jsonArray.get(i));
            }
        }
        if(object instanceof String || object instanceof Integer) {
            System.out.println(object.toString());
        }
    }

    public static List<String> getUsernameList(){
        List<String> userList = new ArrayList<>();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(schemeValue)
                .host(hostValue)
                .port(portVale)
                .addPathSegment(projectValue)
                .addPathSegment("user")
                .addPathSegment("list")
                .build();
        Request request = new Request.Builder().url(httpUrl).build();
        JSONArray jsonArray = null;
        try{
            Response response = okHttpClient.newCall(request).execute();
            if(response.isSuccessful()){
                assert response.body() != null;
                jsonArray = JSONArray.parseArray(Objects.requireNonNull(response.body()).string());
                for(Object object : jsonArray){
                    if(object instanceof JSONObject){
                        JSONObject jsonObject = (JSONObject) object;
                        String userName = jsonObject.get("name").toString().trim();
                        userList.add(userName);
                    }
                }
            }
        }catch (Exception e){
            log.info(String.valueOf(e));
        }
        return userList;
    }

    public static JSONObject getUserName(String userID){
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(schemeValue)
                .host(hostValue)
                .port(portVale)
                .addPathSegment(projectValue)
                .addPathSegment("user")
                .addPathSegment(userID)
                .build();
        Request request = new Request.Builder().url(httpUrl).build();
        JSONObject jsonObject = null;
        try{
            Response response = okHttpClient.newCall(request).execute();
            if(response.isSuccessful()){
                assert response.body() != null;
                jsonObject = JSONObject.parseObject(Objects.requireNonNull(response.body()).string());
            }
        }catch (Exception e){
            log.error("parse json object failure", e);
        }
        return jsonObject;
    }
}

class test{
    public static void main(String[] args){
        List<String> usernameList = HttpRequestUtil.getUsernameList();
        System.out.println(usernameList);
        JSONObject jsonObject = HttpRequestUtil.getUserName("1");
        System.out.println(jsonObject.get("name").toString().trim());
    }
}