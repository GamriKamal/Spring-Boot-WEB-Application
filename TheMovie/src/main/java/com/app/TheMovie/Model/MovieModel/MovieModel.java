package com.app.TheMovie.Model.MovieModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DecimalFormat;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String original_language;
    private String original_title;
    private String backdrop_path;
    private String overview;
    private double popularity;
    private String poster_path;
    private String release_date;
    private String title;
    private double vote_average;
    private int vote_count;


    public MovieModel(String id, String original_title, String overview, double popularity, String poster_path, String release_date, String title, double vote_average) {
        this.id = id;
        this.original_title = original_title;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.title = title;
        this.vote_average = vote_average;
    }

    public MovieModel(String id) {
        this.id = id;
    }

    public double getVote_average() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.0");
        return Double.parseDouble(decimalFormat.format(vote_average));
    }

    public String getBackdrop_path() {
        backdrop_path = "http://image.tmdb.org/t/p/original"+backdrop_path;
        return backdrop_path;
    }


    public String getPoster_path() {
        poster_path = "http://image.tmdb.org/t/p/original"+poster_path;
        return poster_path;
    }

}
