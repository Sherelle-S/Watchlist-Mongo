package com.cbfacademy.apiassessment.MongoDB;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.model.Watchlist;

@Repository
public interface MongoWatchlistRepository extends MongoRepository <Watchlist, UUID> {

    List<Watchlist> findAllByOrderByStockNameAsc();
}
