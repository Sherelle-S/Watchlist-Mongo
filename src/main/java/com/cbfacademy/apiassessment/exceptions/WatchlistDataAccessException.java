package com.cbfacademy.apiassessment.exceptions;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//  Custom exception class representing data access issues specific to the watchlist.
//  It is a subclass of IOException and indicates errors related to accessing watchlist data.

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class WatchlistDataAccessException extends IOException{

    public WatchlistDataAccessException(){}
    public WatchlistDataAccessException(String message){
        super(message);
    }

    public WatchlistDataAccessException(String message, String exception){
        super(message);
    }

    public WatchlistDataAccessException(Throwable cause){
    super(cause);
    }

    public WatchlistDataAccessException(String message, Throwable cause){
        super(message, cause);
    }
    
}
