package com.app.TheMovie.Model.MovieModel;

import com.app.TheMovie.Model.GenresDetailsModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONException;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;

@Getter
@Setter
@NoArgsConstructor
public class MovieDetailsModel extends CompletableFuture<MovieDetailsModel> {
    private String title, backdrop_path, budget, id, homepage,
            overview, popularity, poster_path, release_date,
            revenue, runtime, tagline, vote_average, genresName, original_title, statusMovie;
    private List<GenresDetailsModel> genres;
    private GenresDetailsModel genresDetailsModel = new GenresDetailsModel();
    public MovieDetailsModel(String title, String backdrop_path, String budget, JSONArray genres, String id, String homepage, String overview, String popularity,
                             String poster_path, String release_date, String revenue, String runtime, String tagline, String vote_average, String original_title, String statusMovie) throws JSONException {
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.budget = budget;
        this.genres = genresDetailsModel.fromJSONtoList(genres);
        this.id = id;
        this.homepage = homepage;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.revenue = revenue;
        this.runtime = runtime;
        this.tagline = tagline;
        this.vote_average = vote_average;
        this.original_title = original_title;
        this.statusMovie = statusMovie;
    }

    public MovieDetailsModel(String title, String backdrop_path, String budget, String id, String homepage, String overview, String popularity, String poster_path, String release_date, String revenue, String runtime, String tagline, String vote_average, String genresName, String original_title, String statusMovie) {
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.budget = budget;
        this.id = id;
        this.homepage = homepage;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.revenue = revenue;
        this.runtime = runtime;
        this.tagline = tagline;
        this.vote_average = vote_average;
        this.genresName = genresName;
        this.original_title = original_title;
        this.statusMovie = statusMovie;
    }

    public String getBackdrop_path() {
        backdrop_path = "http://image.tmdb.org/t/p/original"+backdrop_path;
        return backdrop_path;
    }

    public String getGenres() throws JSONException {
        String str = " ";
        for(int i = 0; i < genres.size(); i++){
            if(str.equals(" ")){
                str = " " +genres.get(i).getName() + ",  " + str;
            } else if (i + 1 == genres.size()) {
                str = str + genres.get(i).getName();
            } else {
                str = str + genres.get(i).getName() + ",  ";
            }
        }
        return str;
    }

    public String getBudget() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        return formatter.format(Integer.valueOf(budget));
    }

    public String getPoster_path() {
        poster_path = "http://image.tmdb.org/t/p/w500"+poster_path;
        return poster_path;
    }
    public String getRevenue() {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        String currency = format.format(Integer.valueOf(revenue));
        return currency;
    }

    public String getVote_average() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.0");
        return String.valueOf(decimalFormat.format(Double.valueOf(vote_average)));
    }

    @Override
    public String toString() {
        return "MovieDetailsModel{" +
                "title='" + title + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", budget='" + budget + '\'' +
                ", id='" + id + '\'' +
                ", homepage='" + homepage + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity='" + popularity + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", release_date='" + release_date + '\'' +
                ", revenue='" + revenue + '\'' +
                ", runtime='" + runtime + '\'' +
                ", tagline='" + tagline + '\'' +
                ", vote_average='" + vote_average + '\'' +
                ", genresName='" + genresName + '\'' +
                ", original_title='" + original_title + '\'' +
                ", statusMovie='" + statusMovie + '\'' +
                ", genres=" + genres +
                ", genresDetailsModel=" + genresDetailsModel +
                '}';
    }
}
