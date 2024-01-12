package com.cbfacademy.apiassessment.MongoDB;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.exceptions.WatchlistDataAccessException;
import com.cbfacademy.apiassessment.model.Watchlist;

@Component
public class MongoSoftDelete {

      @Autowired
    private MongoWatchlistRepository repo;


      public void deleteByUuid(UUID uuid) throws WatchlistDataAccessException {
    //     Watchlist watchlist = repo.findById(uuid).orElse(null);
    //     if (watchlist != null) {
    //         watchlist.setDeleted(true);
    //         watchlist.setDeletedAt(LocalDateTime.now());
    //         repo.save(watchlist);
    //     }else {
    //         throw new WatchlistDataAccessException("Watchlist entry not available.");
    //     }
    //     // Handle if the document doesn't exist or other errors
    }
}
