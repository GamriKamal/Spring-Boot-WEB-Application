package com.app.TheMovie.Services;

import com.app.TheMovie.Model.MovieModel.*;
import com.app.TheMovie.Model.TVModel.TVDetailExternalID;
import com.app.TheMovie.Model.TVModel.TVDetailsModel;
import com.app.TheMovie.Model.TVModel.TVModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
@Service
public class Transfer {
    private static volatile Transfer instance;
    public static Transfer getInstance() {
        Transfer localInstance = instance;
        if (localInstance == null) {
            synchronized (Transfer.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Transfer();
                }
            }
        }
        return localInstance;
    }
    public List<MovieModel> fromJSONArraytoListMovie(JSONArray objJSONArray) throws JSONException {
        List<MovieModel> modelList = new ArrayList<>();
        for(int i = 0; i < objJSONArray.length(); i++){
            MovieModel model = new MovieModel(
                    objJSONArray.getJSONObject(i).getString("id"),
                    objJSONArray.getJSONObject(i).getString("original_title"),
                    objJSONArray.getJSONObject(i).getString("overview"),
                    objJSONArray.getJSONObject(i).getDouble("popularity"),
                    objJSONArray.getJSONObject(i).getString("poster_path"),
                    objJSONArray.getJSONObject(i).getString("release_date"),
                    objJSONArray.getJSONObject(i).getString("title"),
                    objJSONArray.getJSONObject(i).getDouble("vote_average")
            );
            modelList.add(model);
        }

        return modelList;
    }

    public List<TVModel> fromJSONArraytoListTV(JSONArray objJSONArray) throws JSONException {
        List<TVModel> modelList = new ArrayList<>();
        for(int i = 0; i < objJSONArray.length(); i++){
            TVModel tvmodel = new TVModel(
                    objJSONArray.getJSONObject(i).getString("id"),
                    objJSONArray.getJSONObject(i).getString("name"),
                    objJSONArray.getJSONObject(i).getString("original_name"),
                    objJSONArray.getJSONObject(i).getString("overview"),
                    objJSONArray.getJSONObject(i).getDouble("popularity"),
                    objJSONArray.getJSONObject(i).getDouble("vote_average"),
                    objJSONArray.getJSONObject(i).getString("poster_path"),
                    objJSONArray.getJSONObject(i).getString("first_air_date")
            );
            modelList.add(tvmodel);
        }

        return modelList;
    }

    public List<MovieModelCast> fromJSONArrayToListMovieCast(JSONArray jsonArray) throws JSONException{
        List<MovieModelCast> modelList = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++){
            MovieModelCast model = new MovieModelCast(
                    jsonArray.getJSONObject(i).getString("id"),
                    jsonArray.getJSONObject(i).getString("character"),
                    jsonArray.getJSONObject(i).getString("credit_id"),
                    jsonArray.getJSONObject(i).getString("name"),
                    jsonArray.getJSONObject(i).getString("known_for_department"),
                    jsonArray.getJSONObject(i).getString("profile_path")
            );
            modelList.add(model);
        }

        return modelList;
    }

    public List<MovieModelCrew> fromJSONArrayToListMovieCrew(JSONArray jsonArray) throws JSONException{
        List<MovieModelCrew> modelList = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++){
            MovieModelCrew model = new MovieModelCrew(
                    jsonArray.getJSONObject(i).getString("id"),
                    jsonArray.getJSONObject(i).getString("job"),
                    jsonArray.getJSONObject(i).getString("credit_id"),
                    jsonArray.getJSONObject(i).getString("profile_path"),
                    jsonArray.getJSONObject(i).getString("name"),
                    jsonArray.getJSONObject(i).getString("known_for_department")
            );
            modelList.add(model);
        }
        return modelList;
    }

    public List<MovieModelCrew> fromJSONArrayToListMovieCrewProducer(JSONArray jsonArray) throws JSONException{
        List<MovieModelCrew> modelList = new ArrayList<>();
        MovieModelCrew model = null;
        for(int i = 0; i < jsonArray.length(); i++){
            if(jsonArray.getJSONObject(i).getString("job").equals("Director")){
                 model = new MovieModelCrew(
                        jsonArray.getJSONObject(i).getString("id"),
                        jsonArray.getJSONObject(i).getString("job"),
                        jsonArray.getJSONObject(i).getString("credit_id"),
                        jsonArray.getJSONObject(i).getString("profile_path"),
                        jsonArray.getJSONObject(i).getString("name"),
                        jsonArray.getJSONObject(i).getString("known_for_department")
                );
            }
            modelList.add(model);
        }
        return modelList;
    }

    public List<MovieModelKeywords> fromJSONArrayToMovieListKeywords(JSONArray jsonArray) throws JSONException{
        List<MovieModelKeywords> modelList = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++){
            MovieModelKeywords model = new MovieModelKeywords(
                    jsonArray.getJSONObject(i).getString("id"),
                    jsonArray.getJSONObject(i).getString("name")
            );
            modelList.add(model);
        }
        return modelList;
    }

    public MovieDetailsModel fromJSONObjectToModelMovie(JSONObject jsonObject) throws JSONException, ExecutionException, InterruptedException, TimeoutException {
        MovieDetailsModel detailsModel = new MovieDetailsModel(
                jsonObject.getString("title"),
                jsonObject.getString("backdrop_path"),
                jsonObject.getString("budget"),
                jsonObject.getJSONArray("genres"),
                jsonObject.getString("id"),
                jsonObject.getString("homepage"),
                jsonObject.getString("overview"),
                jsonObject.getString("popularity"),
                jsonObject.getString("poster_path"),
                jsonObject.getString("release_date"),
                jsonObject.getString("revenue"),
                jsonObject.getString("runtime"),
                jsonObject.getString("tagline"),
                jsonObject.getString("vote_average"),
                jsonObject.getString("original_title"),
                jsonObject.getString("status")
        );
        return detailsModel;
    }
    public MovieVideoModel fromJSONObjectToMovieVideo(JSONArray jsonArray) throws JSONException{
        MovieVideoModel model = null;
        for(int i = 0; i < jsonArray.length(); i++){
            if(jsonArray.getJSONObject(i).getString("name").equals("Official Trailer")){
                model = new MovieVideoModel(
                        jsonArray.getJSONObject(i).getString("name"),
                        jsonArray.getJSONObject(i).getString("key")
                );
            }
        }
        return model;
    }

    public TVDetailsModel fromJSONObjectToModelTV(JSONObject jsonObject) throws JSONException {
        TVDetailsModel detailsTVModel = new TVDetailsModel(
                jsonObject.getString("id"),
                jsonObject.getString("name"),
                jsonObject.getString("backdrop_path"),
                jsonObject.getString("first_air_date"),
                jsonObject.getJSONArray("genres"),
                jsonObject.getJSONObject("last_episode_to_air"),
                jsonObject.getString("homepage"),
                jsonObject.getString("last_air_date"),
                jsonObject.getString("number_of_seasons"),
                jsonObject.getString("number_of_episodes"),
                jsonObject.getString("overview"),
                jsonObject.getString("popularity"),
                jsonObject.getString("poster_path"),
                jsonObject.getString("tagline"),
                jsonObject.getString("vote_average"),
                jsonObject.getString("original_name"),
                jsonObject.getString("status")
        );
        return detailsTVModel;
    }

    public MovieDetailExternalID fromJSONObjectToModelExternalID(JSONObject jsonObject) throws JSONException {
        MovieDetailExternalID id = new MovieDetailExternalID(
                jsonObject.getString("id"),
                jsonObject.getString("facebook_id"),
                jsonObject.getString("instagram_id"),
                jsonObject.getString("twitter_id")
        );
        return id;
    }

    public TVDetailExternalID fromJSONObjectToTVExternalID(JSONObject jsonObject) throws JSONException {
        TVDetailExternalID id = new TVDetailExternalID(
                jsonObject.getString("id"),
                jsonObject.getString("facebook_id"),
                jsonObject.getString("instagram_id"),
                jsonObject.getString("twitter_id")
        );
        return id;
    }

}
