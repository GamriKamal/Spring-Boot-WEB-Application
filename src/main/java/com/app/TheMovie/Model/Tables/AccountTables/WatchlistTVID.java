package com.app.TheMovie.Model.Tables.AccountTables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class WatchlistTVID {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String TVID, userId;
    private String userName, movieName;

    @ManyToOne
    @JoinColumn(name = "userAccountID", nullable = false)
    private UserAccount userAccount;

    public WatchlistTVID(String TVID, String userId, String userName, String movieName) {
        this.TVID = TVID;
        this.userId = userId;
        this.userName = userName;
        this.movieName = movieName;
    }
}
