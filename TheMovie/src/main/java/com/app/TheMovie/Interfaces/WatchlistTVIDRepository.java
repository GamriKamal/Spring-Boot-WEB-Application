package com.app.TheMovie.Interfaces;

import com.app.TheMovie.Model.Account.WatchlistTVID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchlistTVIDRepository extends JpaRepository<WatchlistTVID, Long> {
    boolean existsByTVID(String TVID);

}
