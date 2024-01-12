package com.cbfacademy.apiassessment.crudActions.appendingActions.read;

import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.databind.ObjectMapper;

// houses any items necessary to get watchlist data ana return it
@Component
public class RunGetWatchlist {

    private static final Logger log = LoggerFactory.getLogger(RunGetWatchlist.class);

    private ReadExistingWatchlist readList;

    @Autowired
    public RunGetWatchlist(ReadExistingWatchlist readList) {
        this.readList = readList;
    }

    // responsible for controlling the activities of a get request
    public List<Watchlist> getWatchlist(String jsonRepo, ObjectMapper mapper) throws IOException{
        try {
            List<Watchlist> watchlist = readList.readExistingWatchlist(jsonRepo, mapper);
            
            log.info("Get Watchlist has run.");
            log.info("watchlist in GET at getWatchlist: {}", watchlist);
            return watchlist;
        } catch (JsonParseException e) {
            log.error("Exception ocurred while retrieving watchlist data", e.getMessage());
            throw new JsonParseException();
        } catch (IOException e) {
            log.error("IOException while reading json file", e.getMessage());
            throw new IOException();//ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
