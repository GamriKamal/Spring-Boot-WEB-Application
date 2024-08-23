package com.app.TheMovie.Services;

import com.app.TheMovie.Model.Tables.TVModel;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TMDBTVLists {
    private Transfer transfer = Transfer.getInstance();
    private ParseJSONArray parse = ParseJSONArray.getInstance();

    public List<TVModel> getOnTheAir() throws JSONException, IOException{
        return transfer.fromJSONArraytoListTV(parse.getJSONArrayResults("https://api.themoviedb.org/3/tv/on_the_air"));
    }

    public List<TVModel> getPopular() throws JSONException, IOException{
        return transfer.fromJSONArraytoListTV(parse.getJSONArrayResults("https://api.themoviedb.org/3/tv/popular"));
    }

    public List<TVModel> getTopRated() throws JSONException, IOException{
        return transfer.fromJSONArraytoListTV(parse.getJSONArrayResults("https://api.themoviedb.org/3/tv/top_rated"));
    }
}
