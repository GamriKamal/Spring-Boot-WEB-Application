package com.app.TheMovie.Model.Tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DecimalFormat;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TVModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String first_air_date;
    private String original_name;
    private String overview;
    private double popularity;
    private double vote_average;
    private String poster_path;
    private String idTV;

    public TVModel(String id, String name, String original_name, String overview, double popularity, double vote_average, String poster_path, String first_air_date) {
        this.idTV = id;
        this.name = name;
        this.original_name = original_name;
        this.overview = overview;
        this.popularity = popularity;
        this.vote_average = vote_average;
        this.poster_path = poster_path;
        this.first_air_date = first_air_date;
    }

    public TVModel(int id) {
        this.id = id;
    }

    public double getVote_average() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.0");
        return Double.parseDouble(decimalFormat.format(vote_average));
    }

    public String getPoster_path() {
        poster_path = "http://image.tmdb.org/t/p/w500"+poster_path;
        return poster_path;
    }

}
