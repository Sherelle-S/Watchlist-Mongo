package com.cbfacademy.apiassessment.crudActions.appendingActions.sharedCrudMethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.model.Watchlist;

@Component
public class NewWatchlistConstructor {
  
    private static final Logger log = LoggerFactory.getLogger(NewWatchlistConstructor.class);

    // Updates One existing entry, to be used with the PUT operations.
    // @Autowired
    public Watchlist updateOneItem(Watchlist existingEntry, Watchlist newEntry){
        existingEntry.setSymbol(newEntry.getSymbol());
        existingEntry.setOwnsVolStock(newEntry.getOwnsVolStock());
        existingEntry.setCurrency(newEntry.getCurrency());
        existingEntry.setWantsVolStock(newEntry.getWantsVolStock());
        existingEntry.setCurrentPrice(newEntry.getCurrentPrice());
        existingEntry.setPurchasePrice(newEntry.getPurchasePrice());
        existingEntry.setProfit(newEntry.getProfit());
        existingEntry.setPointsChange(newEntry.getPointsChange());
        existingEntry.setOpen(newEntry.getOpen());
        existingEntry.setClose(newEntry.getClose());
        existingEntry.setIntradayHigh(newEntry.getIntradayHigh());
        log.info("object update one item has been created.");
        return newEntry;
    }
}
