package com.app.TheMovie.Controllers;

import com.app.TheMovie.Services.TMDBTVLists;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class TVListsController {

    @Autowired
    private TMDBTVLists tmdbtvLists;

    @GetMapping("TVLists/onTheAir")
    public String onTheAir(Model model) throws JSONException, IOException {
        model.addAttribute("tvListOnTheAir", tmdbtvLists.getOnTheAir());
        return "TVLists/TVList_OnTheAir";
    }

    @GetMapping("TVLists/popular")
    public String popular(Model model) throws JSONException, IOException {
        model.addAttribute("tvListPopular", tmdbtvLists.getPopular());
        return "TVLists/TVList_Popular";
    }

    @GetMapping("TVLists/topRated")
    public String topRated(Model model) throws JSONException, IOException {
        model.addAttribute("tvListTopRated", tmdbtvLists.getTopRated());
        return "TVLists/TVList_TopRated";
    }

}
