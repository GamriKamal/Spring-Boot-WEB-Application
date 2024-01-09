package com.app.TheMovie.Services;

import com.app.TheMovie.Model.MovieModel.MovieModel;
import com.app.TheMovie.Model.TVModel.TVModel;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DiscoverLists {
    private Transfer transfer = Transfer.getInstance();
    private ParseJSONArray parse = ParseJSONArray.getInstance();

    public List<MovieModel> discoverMovieList() throws JSONException, IOException {
        return transfer.fromJSONArraytoListMovie(parse.getJSONArrayResults("https://api.themoviedb.org/3/discover/movie"));
    }
    
    public List<TVModel> discoverTVList() throws JSONException, IOException {
        return transfer.fromJSONArraytoListTV(parse.getJSONArrayResults("https://api.themoviedb.org/3/discover/tv"));
    }

}
