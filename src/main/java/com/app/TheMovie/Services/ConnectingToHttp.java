package com.app.TheMovie.Services;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConnectingToHttp extends GetAPIKey{
    protected final String API_Access_Key = getAPI_Access_Key();

    public ConnectingToHttp() {
    }

    public Response getResponseOfConnection(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("accept", "application/json")
                .addHeader("Authorization", API_Access_Key)
                .build();

        Response response = client.newCall(request).execute();
        return response;
    }
}
