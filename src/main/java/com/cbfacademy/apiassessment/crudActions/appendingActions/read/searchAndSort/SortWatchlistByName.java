package com.cbfacademy.apiassessment.crudActions.appendingActions.read.searchAndSort;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.crudActions.appendingActions.read.RunGetWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.databind.ObjectMapper;

// takes in an existing watchlist and returns a watchlist object sorted by name after quicksort algorithm,
@Component
public class SortWatchlistByName {
 
    @Autowired
    private static final Logger log = LoggerFactory.getLogger(SortWatchlistByName.class);
    private RunGetWatchlist getWatchlist;
    private QuicksortWatchlist sortAlgo;
    public Object sortedWatchlist;

    public SortWatchlistByName(RunGetWatchlist getWatchlist, QuicksortWatchlist sortAlgo) {
        this.sortAlgo = sortAlgo;
        this.getWatchlist = getWatchlist;
    }
// some of these String Name and Object Mapper is necessary for Binary search algo which uses data returned from quicksort, they should not be removed.
        public List<Watchlist> sortedWatchlist(List<Watchlist> existingWatchlist, String name, ObjectMapper mapper) throws IOException{
            List<Watchlist> sortedWatchlist = sortAlgo.sortAlgo(existingWatchlist);
            log.info("Sort by name is processing quicksort request.");
            return sortedWatchlist;
    }
}
