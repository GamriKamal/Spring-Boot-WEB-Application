package com.app.TheMovie.Services;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ParseJSONArray {
    private static volatile ParseJSONArray instance;
    private ConnectingToHttp responseHttp = new ConnectingToHttp();

    public static ParseJSONArray getInstance() {
        ParseJSONArray localInstance = instance;
        if (localInstance == null) {
            synchronized (ParseJSONArray.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ParseJSONArray();
                }
            }
        }
        return localInstance;
    }
    public JSONArray getJSONArrayResults(String url) throws IOException, JSONException {
        JSONArray objJSONArray = new JSONObject(responseHttp.getResponseOfConnection(url)
                .body()
                .string())
                .getJSONArray("results");
        return objJSONArray;
    }

    public JSONArray getJSONArrayCreditsCast(String url) throws IOException, JSONException {
        JSONArray objJSONArray = new JSONObject(responseHttp.getResponseOfConnection(url)
                .body()
                .string())
                .getJSONArray("cast");
        System.out.println(objJSONArray.toString());
        return objJSONArray;
    }

    public JSONArray getJSONArrayKeywords(String url) throws IOException, JSONException {
        JSONArray objJSONArray = new JSONObject(responseHttp.getResponseOfConnection(url)
                .body()
                .string())
                .getJSONArray("keywords");
        return objJSONArray;
    }

    public JSONArray getJSONArrayCreditsCrew(String url) throws IOException, JSONException {
        JSONArray objJSONArray = new JSONObject(responseHttp.getResponseOfConnection(url)
                .body()
                .string())
                .getJSONArray("crew");
        return objJSONArray;
    }



}
