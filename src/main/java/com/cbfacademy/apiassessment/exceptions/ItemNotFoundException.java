package com.cbfacademy.apiassessment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//  Exception class representing a scenario where a specific item is not found in the watchlist.
//  This class extends RuntimeException and is used to indicate that a particular item in the watchlist could not be found.

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ItemNotFoundException extends RuntimeException {

    
    public ItemNotFoundException(String id){
        super("Could not find watchList item " + id);
    }

    public ItemNotFoundException(String message, String cause){
        super(message);
    }

}
