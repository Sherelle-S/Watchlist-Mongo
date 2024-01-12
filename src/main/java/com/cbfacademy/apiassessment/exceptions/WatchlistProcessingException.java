

package com.cbfacademy.apiassessment.exceptions;

import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;

// custom exception for processing when json data fails and sets https response
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class WatchlistProcessingException extends JsonProcessingException{

    public WatchlistProcessingException(String msg, JsonLocation loc) {
        super(msg, loc);
    }

    public WatchlistProcessingException(String msg, ParseException cause) {
        super(msg);
    }

    public WatchlistProcessingException(String msg, Throwable rootCause) {
        super(msg, rootCause);
    }

    public WatchlistProcessingException(String msg) {
        super(msg);
    }

    public WatchlistProcessingException(String msg, String message) {
        super(msg);
    }

}
