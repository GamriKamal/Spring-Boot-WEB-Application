package com.app.TheMovie.Interfaces;

import com.app.TheMovie.Model.Account.WatchlistMovieId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchlistMovieIdRepository extends JpaRepository<WatchlistMovieId, Long> {
    boolean existsByMovieID(String movieID);

}
