package com.app.TheMovie.Services;

import com.app.TheMovie.Model.Tables.MovieModel;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SearchMovieOrTV {
    private Transfer transfer = Transfer.getInstance();
    private ParseJSONArray parse = ParseJSONArray.getInstance();
    private GetAPIKey APIKey = new GetAPIKey();

    public List<? extends Object> getMovieOrTv(String user_input) throws IOException, JSONException {
        String url = "https://api.themoviedb.org/3/search/movie" + "?api_key=" + APIKey.getAPI_Access_Key() + "&query=" + user_input;
        List<MovieModel> list = transfer.fromJSONArraytoListMovie(parse.getJSONArrayResults(url));
        if(list.isEmpty()){
            return transfer.fromJSONArraytoListTV(parse.getJSONArrayResults(url));
        }
        return list;
    }
}
