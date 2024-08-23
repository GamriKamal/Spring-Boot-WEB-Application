package com.app.TheMovie.Interfaces;

import com.app.TheMovie.Model.Tables.AccountTables.FavouriteUserMovieID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteUserMovieRepository extends JpaRepository<FavouriteUserMovieID, Long> {
    boolean existsByMovieID(String movieID);
}
