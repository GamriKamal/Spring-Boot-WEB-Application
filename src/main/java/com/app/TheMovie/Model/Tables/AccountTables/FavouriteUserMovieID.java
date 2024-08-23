package com.app.TheMovie.Model.Tables.AccountTables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FavouriteUserMovieID {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String movieID, userId;
    private String userName, movieName;

    @ManyToOne
    @JoinColumn(name = "userAccountID", nullable = false)
    private UserAccount userAccount;

    public FavouriteUserMovieID(String movieID, String userId, String userName, String movieName) {
        this.movieID = movieID;
        this.userId = userId;
        this.userName = userName;
        this.movieName = movieName;
    }
}
