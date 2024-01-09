package com.app.TheMovie.Services;

import com.app.TheMovie.Model.MovieModel.*;
import com.app.TheMovie.Model.TVModel.TVDetailExternalID;
import com.app.TheMovie.Model.TVModel.TVDetailsModel;
import org.json.JSONException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Service
public class AdditionInfo {

    private Transfer transfer = Transfer.getInstance();
    private ParseJSONArray jsonArray = ParseJSONArray.getInstance();
    private ParseJSONObject jsonObject = ParseJSONObject.getInstance();

    @Cacheable("movieModelVideoCache")
    public MovieVideoModel getMovieVideo(String id) throws JSONException, IOException{
        return transfer.fromJSONObjectToMovieVideo(jsonArray.getJSONArrayResults("https://api.themoviedb.org/3/movie/" + id + "/videos"));
    }

    @Cacheable("movieModelCastCache")
    public List<MovieModelCast> getMovieCast(String id) throws JSONException, IOException {
        return transfer.fromJSONArrayToListMovieCast(jsonArray.getJSONArrayCreditsCast("https://api.themoviedb.org/3/movie/"+ id + "/credits"));
    }

    @Cacheable("movieModelCastCache")
    public List<MovieModelCast> getFirstSixMovieCast(String id) throws JSONException, IOException {
        return getMovieCast(id).subList(0, 6);
    }

    @Cacheable("movieModelCrewCache")
    public List<MovieModelCrew> getMovieCrew(String id) throws JSONException, IOException {
        return transfer.fromJSONArrayToListMovieCrew(jsonArray.getJSONArrayCreditsCrew("https://api.themoviedb.org/3/movie/"+ id + "/credits"));
    }

    @Cacheable("movieModelCastCache")
    public List<MovieModelCast> getTVCast(String id) throws JSONException, IOException {
        return transfer.fromJSONArrayToListMovieCast(jsonArray.getJSONArrayCreditsCast("https://api.themoviedb.org/3/tv/"+ id + "/credits"));
    }

    @Cacheable("movieModelCastCache")
    public List<MovieModelCast> getFirstSixTVCast(String id) throws JSONException, IOException {
        return getTVCast(id);
    }

    @Cacheable("movieModelCrewCache")
    public List<MovieModelCrew> getTVCrew(String id) throws JSONException, IOException {
        return transfer.fromJSONArrayToListMovieCrew(jsonArray.getJSONArrayCreditsCrew("https://api.themoviedb.org/3/tv/"+ id + "/credits"));
    }

    public List<MovieModelCrew> getCrewProducer(String id) throws JSONException, IOException {
        return transfer.fromJSONArrayToListMovieCrewProducer(jsonArray.getJSONArrayCreditsCrew("https://api.themoviedb.org/3/movie/"+ id + "/credits"));
    }

    @Cacheable("movieModelKeywordsCache")
    public List<MovieModelKeywords> getMovieKeywordsList(String id) throws JSONException, IOException{
        return transfer.fromJSONArrayToMovieListKeywords(jsonArray.getJSONArrayKeywords("https://api.themoviedb.org/3/movie/" + id + "/keywords"));
    }

    @Cacheable("movieModelKeywordsCache")
    public List<MovieModelKeywords> getTVKeywordsList(String id) throws JSONException, IOException{
        return transfer.fromJSONArrayToMovieListKeywords(jsonArray.getJSONArrayResults("https://api.themoviedb.org/3/tv/" + id + "/keywords"));
    }


    /*-------------------------------------------------------------------------------------------------------------------------------------------------*/
    @Cacheable("movieDetailsModel")
    public MovieDetailsModel getAdditionInfoMovie(String id) throws JSONException, IOException, ExecutionException, InterruptedException, TimeoutException {
        return transfer.fromJSONObjectToModelMovie(jsonObject.getJSONObjectAdditionInfo("https://api.themoviedb.org/3/movie/" + id));
    }

    @Cacheable("movieDetailExternalID")
    public MovieDetailExternalID getExternalMovieIDs(String id) throws JSONException, IOException{
        return transfer.fromJSONObjectToModelExternalID(jsonObject.getJSONObjectExternalIDs("https://api.themoviedb.org/3/movie/" + id + "/external_ids"));
    }

    @Cacheable("tvDetailExternalID")
    public TVDetailExternalID getExternalTVIDs(String id) throws JSONException, IOException{
        return transfer.fromJSONObjectToTVExternalID(jsonObject.getJSONObjectExternalIDs("https://api.themoviedb.org/3/tv/" + id + "/external_ids"));
    }

    @Cacheable("tvDetailsModel")
    public TVDetailsModel getAdditionInfoTV(String id) throws JSONException, IOException {
        return transfer.fromJSONObjectToModelTV(jsonObject.getJSONObjectAdditionInfo("https://api.themoviedb.org/3/tv/" + id));
    }

    @Cacheable("backDropPathTV")
    public String getBackDropPathTV(String id) throws JSONException, IOException {
        return getAdditionInfoTV(id).getPoster_path();
    }
}
