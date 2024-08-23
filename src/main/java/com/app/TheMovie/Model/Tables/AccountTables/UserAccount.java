package com.app.TheMovie.Model.Tables.AccountTables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username, password, role, mail, phoneNumber;

    @OneToMany(mappedBy = "userAccount")
    private List<FavouriteUserMovieID> listOfFavouriteUserMovieID;

    @OneToMany(mappedBy = "userAccount")
    private List<WatchlistMovieId> watchListMovies;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_favorite_movies",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "movie_id")
//    )
//    private List<MovieModel> favouriteMovie = new ArrayList<>();
//
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_favorite_tv_shows",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "tv_id")
//    )
//    private List<TVModel> favouriteTV = new ArrayList<>();
//
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_watchlist_movies",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "movie_id")
//    )
//    private List<MovieModel> watchListMovie = new ArrayList<>();
//
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_watchlist_tv_shows",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "tv_id")
//    )
//    private List<TVModel> watchListTV = new ArrayList<>();


    public UserAccount(Long userId, String username, String password, String role, String mail, String phoneNumber) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
    }

}
