package com.app.TheMovie.Controllers;

import com.app.TheMovie.Interfaces.UserAccountRepository;
import com.app.TheMovie.Model.Account.UserAccount;
import com.app.TheMovie.Model.MovieModel.MovieDetailsModel;
import com.app.TheMovie.Services.*;
import jakarta.servlet.http.HttpServletRequest;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import static com.app.TheMovie.Services.NumberFormatter.formatPhoneNumber;

@Controller
public class WelcomePageController {
    private static final java.util.UUID UUID = null;
    @Autowired
    private DiscoverLists discoverLists;

    @Autowired
    private SearchMovieOrTV search;

    @Autowired
    private AdditionInfo info;

    @Autowired
    private AverageColorClass color;

    @Autowired
    private UserAccountRepository repo;

    @Autowired
    private GetAdditionalInfoAccount getAdditionalInfoAccount;

    @Autowired
    private GetUserDetails getUserDetails;

    @GetMapping("/welcomePage")
    public String home(Model model) throws JSONException, IOException {
        model.addAttribute("movieList", discoverLists.discoverMovieList());
        model.addAttribute("tvList", discoverLists.discoverTVList());
        return "welcomePage";
    }

    @GetMapping("/welcomePage/search")
    public String search(Model model, @RequestParam(value = "search-input") String search_input, HttpServletRequest request) throws JSONException, IOException {
        if(search_input.isEmpty()){
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        } else {
            model.addAttribute("list", search.getMovieOrTv(search_input));
            model.addAttribute("input", search_input);
            return "searchMovieOrTV";
        }
    }

    @GetMapping("/login")
    public String login(){
        return "UsersPages/loginPage";
    }

    @GetMapping("/register")
    public String register(){
        return "UsersPages/registerPage";
    }

    @GetMapping("/welcomePage/additionInfoMovie")
    public String additionInfoMovie(Model model, @RequestParam(value = "movieID") String movieID) throws JSONException, IOException, ExecutionException, InterruptedException, TimeoutException {
//        model.addAttribute("movieList", discoverLists.discoverMovieList());
        MovieDetailsModel movieModel = info.getAdditionInfoMovie(movieID);
        model.addAttribute("modelMovie", movieModel);
        model.addAttribute("modelMovieVideo", info.getMovieVideo(movieID));
        model.addAttribute("averageColor", color.calculateAverageColorFromURL(movieModel.getBackdrop_path()));
        model.addAttribute("firstSixCastList", info.getFirstSixMovieCast(movieID));
        model.addAttribute("externalIDsList", info.getExternalMovieIDs(movieID));
        model.addAttribute("keywordsList", info.getMovieKeywordsList(movieID));
        return "MovieLists/Movie_AdditionInfo";
    }

    @GetMapping("/welcomePage/additionInfoMovie/cast")
    public String castMovie(Model model, @RequestParam(value = "movieID") String movieID) throws JSONException, IOException, ExecutionException, InterruptedException, TimeoutException {
        MovieDetailsModel movieModel = info.getAdditionInfoMovie(movieID);

        model.addAttribute("castList", info.getMovieCast(movieID));
        model.addAttribute("crewList", info.getMovieCrew(movieID));
        model.addAttribute("averageColor", color.calculateAverageColorFromURL(movieModel.getBackdrop_path()));
        model.addAttribute("modelMovie", movieModel);
        return "MovieLists/Movie_Cast";
    }

    @GetMapping("/welcomePage/additionInfoTV")
    public String additionInfoTV(Model model, @RequestParam(value = "TVID") String movieID) throws JSONException, IOException {
        model.addAttribute("modelTV", info.getAdditionInfoTV(movieID));
        model.addAttribute("externalIDsList", info.getExternalTVIDs(movieID));
        model.addAttribute("averageColor", color.calculateAverageColorFromURL(info.getBackDropPathTV(movieID)));
        model.addAttribute("keywordsList", info.getTVKeywordsList(movieID));
        model.addAttribute("firstSixCastList", info.getFirstSixTVCast(movieID));
        return "TVLists/TV_AdditionInfo";
    }

    @GetMapping("/welcomePage/additionInfoTV/cast")
    public String castTV(Model model, @RequestParam(value = "TVID") String movieID) throws JSONException, IOException {
        model.addAttribute("castList", info.getTVCast(movieID));
        model.addAttribute("crewList", info.getTVCrew(movieID));
        model.addAttribute("averageColor", color.calculateAverageColorFromURL(info.getBackDropPathTV(movieID)));
        model.addAttribute("modelTV", info.getAdditionInfoTV(movieID));
        return "TVLists/TV_Cast";
    }

    @GetMapping("/account")
    public String account(Model model, Authentication authentication, HttpServletRequest request) throws JSONException, IOException {
        UserAccount user = getUserDetails.getUserDetails(authentication);
        model.addAttribute("nameOfUser", user.getUsername());
        model.addAttribute("mailOfUser", user.getMail());
        model.addAttribute("phoneNumberOfUser", formatPhoneNumber(user.getPhoneNumber()));

        return "UsersPages/accountPage";
    }

    @PostMapping("/addRegister")
    public String addValues(@RequestParam("username") String userName, @RequestParam("email") String email,
                            @RequestParam("phone") String phoneNumber, @RequestParam("password") String password, @RequestParam("confirm-password") String confirmPassword){
        Long uniqueID = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        if (!getAdditionalInfoAccount.isValidEmail(email)) {
            return "redirect:/register?error=email";
        }

        if (!password.equals(confirmPassword)) {
            return "redirect:/register?error=password";
        }

        repo.save(new UserAccount(uniqueID, userName, password, "USER", email, phoneNumber) );

        return "UsersPages/loginPage";
    }

    @PostMapping("/addFavouriteMovie")
    public String addFavouriteMovie(@RequestParam("movieID") String movieID, Authentication authentication, HttpServletRequest request) throws JSONException, IOException, ExecutionException, InterruptedException, TimeoutException {
        getAdditionalInfoAccount.addFavouriteMovie(movieID, authentication, info.getAdditionInfoMovie(movieID));
        request.getSession().setAttribute("successMessage", "Movie added to Favorites successfully.");
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @PostMapping("/addWatchlistMovie")
    public String addWatchlistMovie(@RequestParam("movieID") String movieID, Authentication authentication, HttpServletRequest request) throws JSONException, IOException, ExecutionException, InterruptedException, TimeoutException {
        getAdditionalInfoAccount.addWatchlistMovie(movieID, authentication, info.getAdditionInfoMovie(movieID));
        request.getSession().setAttribute("successMessage", "Movie added to Watchlist successfully.");
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }


    @PostMapping("/addFavouriteTV")
    public String addFavouriteTV(@RequestParam("TVID") String TVID, Authentication authentication, HttpServletRequest request) throws JSONException, IOException {
        getAdditionalInfoAccount.addFavouriteTV(TVID, authentication, info.getAdditionInfoTV(TVID));
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @PostMapping("/addWatchlistTV")
    public String addTVWatchlist(@RequestParam("TVID") String TVID, Authentication authentication, HttpServletRequest request) throws JSONException, IOException {
        getAdditionalInfoAccount.addTVWatchlist(TVID, authentication, info.getAdditionInfoTV(TVID));
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @GetMapping("/account/favouriteMovie")
    public String getFavouriteMovie(Model model, Authentication authentication) throws JSONException, IOException, ExecutionException, InterruptedException, TimeoutException {
        UserAccount user = getUserDetails.getUserDetails(authentication);

        if(user.getUserId().equals(getAdditionalInfoAccount.getUserId(user.getUsername()))){
            model.addAttribute("listOfFavouriteMovies", getAdditionalInfoAccount.getFavouriteMovie(user.getUserId()));
        }

        model.addAttribute("userName", user.getUsername());
        return "UsersPages/accountFavouriteMovies";
    }

    @GetMapping("/account/watchListMovie")
    public String getWatchlisMovie(Model model, Authentication authentication) throws JSONException, IOException, ExecutionException, InterruptedException, TimeoutException {
        UserAccount user = getUserDetails.getUserDetails(authentication);

        model.addAttribute("userName", user.getUsername());

        if(user.getUserId().equals(getAdditionalInfoAccount.getUserId(user.getUsername()))){
            model.addAttribute("watchlistMovies", getAdditionalInfoAccount.getMovieWatchlist(user.getUserId()));
        }

        return "UsersPages/accountMovieWatchlist";
    }

    @GetMapping("/account/favouriteTV")
    public String getFavouriteTV(Model model, Authentication authentication) throws JSONException, IOException {
        UserAccount user = getUserDetails.getUserDetails(authentication);

        if(user.getUserId().equals(getAdditionalInfoAccount.getUserId(user.getUsername()))){
            model.addAttribute("listOfFavouriteTV", getAdditionalInfoAccount.getFavouriteTV(user.getUserId()));
        }

        model.addAttribute("userName", user.getUsername());
        return "UsersPages/accountFavouriteTV";
    }

    @GetMapping("/account/watchListTV")
    public String getTVWatchlist(Model model, Authentication authentication) throws JSONException, IOException {
        UserAccount user = getUserDetails.getUserDetails(authentication);

        if(user.getUserId().equals(getAdditionalInfoAccount.getUserId(user.getUsername()))){
            model.addAttribute("listTVWatchlist", getAdditionalInfoAccount.getTVWatchlist(user.getUserId()));
        }

        model.addAttribute("userName", user.getUsername());
        return "UsersPages/accountTVWatchlist";
    }

}
