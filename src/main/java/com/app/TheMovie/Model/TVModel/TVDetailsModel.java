package com.app.TheMovie.Model.TVModel;

import com.app.TheMovie.Model.GenresDetailsModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TVDetailsModel extends GenresDetailsModel {
    private String id, name, backdrop_path, first_air_date, homepage, last_air_date, number_of_seasons,
            number_of_episodes, overview, popularity, poster_path, tagline, vote_average, original_name, status;
    private List<GenresDetailsModel> genres;
    private List<TVLastEpisodeToAir> lastEpisodeToAirs;
    private TVLastEpisodeToAir lastEpisodeToAir = new TVLastEpisodeToAir();
    public TVDetailsModel(String id, String name, String backdrop_path, String first_air_date, JSONArray genres,
                          JSONObject last_episode_to_air, String homepage, String last_air_date, String number_of_seasons,
                          String number_of_episodes, String overview, String popularity, String poster_path, String tagline,
                          String vote_average, String original_name, String status) throws JSONException {
        this.id = id;
        this.name = name;
        this.backdrop_path = backdrop_path;
        this.first_air_date = first_air_date;
        this.genres = fromJSONtoList(genres);
        this.lastEpisodeToAirs = lastEpisodeToAir.fromJSONtoListTV(last_episode_to_air);
        this.homepage = homepage;
        this.last_air_date = last_air_date;
        this.number_of_seasons = number_of_seasons;
        this.number_of_episodes = number_of_episodes;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.tagline = tagline;
        this.vote_average = vote_average;
        this.original_name = original_name;
        this.status = status;
    }

    public TVDetailsModel(String id, String name, String backdrop_path, String homepage, String last_air_date, String number_of_seasons, String number_of_episodes, String overview, String popularity, String poster_path, String tagline, String vote_average, String original_name, String status) {
        this.id = id;
        this.name = name;
        this.backdrop_path = backdrop_path;
        this.number_of_seasons = number_of_seasons;
        this.number_of_episodes = number_of_episodes;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.tagline = tagline;
        this.vote_average = vote_average;
        this.original_name = original_name;
        this.status = status;
    }

    //    public TVDetailsModel(String id, String name, String backdropPath, String firstAirDate, String genres, List<TVLastEpisodeToAir> lastEpisodeToAirs, String homepage, String lastAirDate, String numberOfSeasons, String numberOfEpisodes, String overview, String popularity, String popularity1, String posterPath, String tagline, String voteAverage, String originalName, String status) {
//    }


    public String getBackdrop_path() {
        backdrop_path = "http://image.tmdb.org/t/p/original"+backdrop_path;
        return backdrop_path;
    }

    public String getVote_average() {
        DecimalFormat df = new DecimalFormat("#.#");
        return String.valueOf(df.format(Double.valueOf(vote_average)));
    }

    public String getPoster_path() {
        poster_path = "http://image.tmdb.org/t/p/w500" + poster_path;
        return poster_path;
    }

    public String getGenres() throws JSONException {
        String str = " ";
        for(int i = 0; i < genres.size(); i++){
            if(str.equals(" ")){
                str = " " + genres.get(i).getName() + ",  " + str;
            } else if (i + 1 == genres.size()) {
                str = str + genres.get(i).getName();
            } else {
                str = str + genres.get(i).getName() + ",  ";
            }
        }
        return str;
    }

}
