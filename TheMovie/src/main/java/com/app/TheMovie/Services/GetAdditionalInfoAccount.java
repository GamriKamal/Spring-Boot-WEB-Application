package com.app.TheMovie.Services;

import com.app.TheMovie.Interfaces.*;
import com.app.TheMovie.Model.Account.*;
import com.app.TheMovie.Model.MovieModel.MovieDetailsModel;
import com.app.TheMovie.Model.TVModel.TVDetailsModel;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Service
public class GetAdditionalInfoAccount {

    @Autowired
    private FavouriteUserMovieRepository favouriteRepo;
    @Autowired
    private WatchlistMovieIdRepository watchlistRepo;
    @Autowired
    private UserAccountRepository userAccountRepo;
    @Autowired
    private FavouriteUserTVRepository favouriteTVRepo;
    @Autowired
    private WatchlistTVIDRepository watchlistTVIDRepo;
    @Autowired
    private AdditionInfo additionInfo;

    public Long getUserId(String username){
        UserAccount user = userAccountRepo.findByUsername(username);
        return user.getUserId();
    }


    public void addFavouriteMovie(String movieID, Authentication authentication, MovieDetailsModel model){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserAccount user = userAccountRepo.findByUsername(userDetails.getUsername());
        String userId = String.valueOf(user.getUserId());
        FavouriteUserMovieID favourite = new FavouriteUserMovieID(movieID, userId, user.getUsername(), model.getTitle());
        favourite.setUserAccount(user);
        boolean filmExists = favouriteRepo.existsByMovieID(movieID);

        if(!filmExists){
            favouriteRepo.save(favourite);
        }
    }

    public void addWatchlistMovie(String movieID, Authentication authentication, MovieDetailsModel model){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserAccount user = userAccountRepo.findByUsername(userDetails.getUsername());

        String userId = String.valueOf(user.getUserId());
        WatchlistMovieId favourite = new WatchlistMovieId(movieID, userId, user.getUsername(), model.getTitle());
        favourite.setUserAccount(user);
        boolean filmExists = watchlistRepo.existsByMovieID(movieID);

        if(!filmExists){
            watchlistRepo.save(favourite);
        }
    }

    public void addFavouriteTV(String TVID, Authentication authentication, TVDetailsModel model){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserAccount user = userAccountRepo.findByUsername(userDetails.getUsername());
        String userId = String.valueOf(user.getUserId());
        FavouriteUserTVID favourite = new FavouriteUserTVID(TVID, userId, user.getUsername(), model.getName());
        favourite.setUserAccount(user);
        boolean filmExists = favouriteTVRepo.existsByTVID(TVID);

        if(!filmExists){
            favouriteTVRepo.save(favourite);
        }
    }

    public void addTVWatchlist(String TVID, Authentication authentication, TVDetailsModel model){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserAccount user = userAccountRepo.findByUsername(userDetails.getUsername());
        String userId = String.valueOf(user.getUserId());
        WatchlistTVID watchlist = new WatchlistTVID(TVID, userId, user.getUsername(), model.getName());
        watchlist.setUserAccount(user);
        boolean filmExists = watchlistTVIDRepo.existsByTVID(TVID);

        if(!filmExists){
            watchlistTVIDRepo.save(watchlist);
        }
    }

    public List<MovieDetailsModel> getFavouriteMovie(Long userID) throws JSONException, IOException, ExecutionException, InterruptedException, TimeoutException {
        List<MovieDetailsModel> modelList = new ArrayList<>();
        List<FavouriteUserMovieID> list = favouriteRepo.findAll();

        for (FavouriteUserMovieID movie : list) {
            if(movie.getUserId().equals(String.valueOf(userID))){
                MovieDetailsModel tempObj = additionInfo.getAdditionInfoMovie(movie.getMovieID());
                modelList.add(tempObj);
            }

        }
        return modelList;
    }

    public List<MovieDetailsModel> getMovieWatchlist(Long userID) throws JSONException, IOException, ExecutionException, InterruptedException, TimeoutException {
        List<MovieDetailsModel> modelList = new ArrayList<>();
        List<WatchlistMovieId> list = watchlistRepo.findAll();

        for (WatchlistMovieId movie : list) {
            if(movie.getUserId().equals(String.valueOf(userID))){
                MovieDetailsModel tempObj = additionInfo.getAdditionInfoMovie(movie.getMovieID());
                modelList.add(tempObj);
            }

        }

        return modelList;
    }

    public List<TVDetailsModel> getFavouriteTV(Long userID) throws JSONException, IOException {
        List<TVDetailsModel> modelList = new ArrayList<>();
        List<FavouriteUserTVID> list = favouriteTVRepo.findAll();

        for (FavouriteUserTVID tv : list) {
            if(tv.getUserId().equals(String.valueOf(userID))){
                TVDetailsModel tempObj = additionInfo.getAdditionInfoTV(tv.getTVID());
                modelList.add(tempObj);
            }

        }

        return modelList;
    }

    public List<TVDetailsModel> getTVWatchlist(Long userID) throws JSONException, IOException {
        List<TVDetailsModel> modelList = new ArrayList<>();
        List<WatchlistTVID> list = watchlistTVIDRepo.findAll();

        for (WatchlistTVID tv : list) {
            if(tv.getUserId().equals(String.valueOf(userID))){
                TVDetailsModel tempObj = additionInfo.getAdditionInfoTV(tv.getTVID());
                modelList.add(new TVDetailsModel(
                        tempObj.getId(), tempObj.getName(), tempObj.getBackdrop_path(),
                        tempObj.getGenres(), tempObj.getLast_air_date(),
                        tempObj.getNumber_of_seasons(), tempObj.getNumber_of_episodes(), tempObj.getOverview(), tempObj.getPopularity(),
                        tempObj.getPoster_path(), tempObj.getTagline(), tempObj.getVote_average(),  tempObj.getOriginal_name(), tempObj.getStatus()
                ));
            }

        }

        return modelList;
    }

    public boolean isValidEmail(String email) {
        String[] allowedDomains = {"gmail.com", "mail.ru", "outlook.com"};

        for (String domain : allowedDomains) {
            if (email.endsWith("@" + domain)) {
                return true;
            }
        }

        return false;
    }
}
