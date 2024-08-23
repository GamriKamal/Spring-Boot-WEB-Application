package com.app.TheMovie.Interfaces;

import com.app.TheMovie.Model.Tables.AccountTables.FavouriteUserTVID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteUserTVRepository extends JpaRepository<FavouriteUserTVID, Long> {
    boolean existsByTVID(String TVID);
}
