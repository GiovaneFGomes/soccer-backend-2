package com.giovane.soccer.exceptions.notfound;

import org.springframework.web.bind.annotation.ResponseStatus;
import static org.springframework.http.HttpStatus.*;

@ResponseStatus(NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}