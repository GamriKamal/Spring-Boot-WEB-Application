package com.app.TheMovie.Interfaces;

import com.app.TheMovie.Model.Tables.AccountTables.WatchlistMovieId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchlistMovieIdRepository extends JpaRepository<WatchlistMovieId, Long> {
    boolean existsByMovieID(String movieID);

}
