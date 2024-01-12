package com.cbfacademy.apiassessment.crudActions.appendingActions.deleteEntries;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.databind.ObjectMapper;

// runs combined components necessary to delete an entry to watchlist
@Service
public class RunDeleteEntry {
    
    private static final Logger log = LoggerFactory.getLogger(RunDeleteEntry.class);

    private DeleteEntry deleteEntry;

    @Autowired
    public RunDeleteEntry(DeleteEntry deleteEntry) {
        this.deleteEntry = deleteEntry;
    }

    public List<Watchlist> runDeleteItem(List<Watchlist> existingWatchlist, String jsonRepo, ObjectMapper mapper, UUID uuid) throws IOException{
        try {
            log.info("Existing list has been read");
            deleteEntry.deleteEntry(existingWatchlist, jsonRepo, mapper, uuid);
            log.info("Item by uuid " + uuid + " has been located");
            log.info("new watchlist is now {}", existingWatchlist);
            return existingWatchlist;
        } catch (Exception e) {
            log.error("IOException thrown while attempting to run runDeleteItem", e.getMessage());
            throw new IOException("Failed to delete item in json file");
        }

    }
}
