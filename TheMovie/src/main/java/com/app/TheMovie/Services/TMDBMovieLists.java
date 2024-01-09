package com.app.TheMovie.Services;

import com.app.TheMovie.Model.MovieModel.MovieModel;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class TMDBMovieLists {
    private Transfer transfer = Transfer.getInstance();
    private ParseJSONArray parse = ParseJSONArray.getInstance();

    public List<MovieModel> popularMovieList() throws JSONException, IOException {
        return transfer.fromJSONArraytoListMovie(parse.getJSONArrayResults("https://api.themoviedb.org/3/movie/popular"));
    }

    public List<MovieModel> nowPlaying() throws JSONException, IOException{
        return transfer.fromJSONArraytoListMovie(parse.getJSONArrayResults("https://api.themoviedb.org/3/movie/now_playing"));
    }

    public List<MovieModel> upcoming() throws JSONException, IOException{
        return transfer.fromJSONArraytoListMovie(parse.getJSONArrayResults("https://api.themoviedb.org/3/movie/upcoming"));
    }
}
