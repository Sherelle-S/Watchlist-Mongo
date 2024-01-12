package com.cbfacademy.apiassessment.exceptions;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//  Exception class representing an invalid input scenario.
//  This class extends IOException and is used to indicate that an input is invalid.

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class InvalidInputException extends IOException {
    public InvalidInputException(){}
    public InvalidInputException(String message){
        super(message);
    }

public InvalidInputException(Throwable cause){
    super(cause);
    }

    public InvalidInputException(String message, Throwable cause){
        super(message, cause);
    }
}
