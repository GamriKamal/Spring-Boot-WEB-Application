package com.app.TheMovie.Services;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@EnableAsync
public class ParseJSONObject {

    private static volatile ParseJSONObject instance;
    private ConnectingToHttp responseHttp = new ConnectingToHttp();

    public static ParseJSONObject getInstance() {
        ParseJSONObject localInstance = instance;
        if (localInstance == null) {
            synchronized (ParseJSONObject.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ParseJSONObject();
                }
            }
        }
        return localInstance;
    }

    public JSONObject getJSONObjectAdditionInfo(String url) throws IOException, JSONException {
        JSONObject jsonObject = new JSONObject(responseHttp.getResponseOfConnection(url)
                .body()
                .string());
        return jsonObject;
    }

    public JSONObject getJSONObjectExternalIDs(String url) throws IOException, JSONException{
        JSONObject jsonObject = new JSONObject(responseHttp.getResponseOfConnection(url)
                .body()
                .string());
        return jsonObject;
    }
}
