package com.app.TheMovie.Controllers;

import com.app.TheMovie.Services.TMDBMovieLists;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class MovieListsController {
    @Autowired
    private TMDBMovieLists movieLists;


    @GetMapping("/movieLists/popularMovieList")
    public String popularMovieList(Model model) throws JSONException, IOException {
        model.addAttribute("movieListPopular", movieLists.popularMovieList());
        return "MovieLists/MovieList_Popular";
    }

    @GetMapping("/movieLists/nowPlaying")
    public String nowPlaying(Model model) throws JSONException, IOException{
        model.addAttribute("movieListNowPlaying", movieLists.nowPlaying());
        return "MovieLists/MovieList_NowPlaying";
    }

    @GetMapping("/movieLists/upcoming")
    public String upcoming(Model model) throws JSONException, IOException{
        model.addAttribute("movieListUpComing", movieLists.upcoming());
        return "MovieLists/MovieList_Upcoming";
    }
}
