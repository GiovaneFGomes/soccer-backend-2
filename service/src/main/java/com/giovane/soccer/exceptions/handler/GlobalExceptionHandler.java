package com.giovane.soccer.exceptions.handler;

import java.util.List;
import java.util.Map;
import java.time.Instant;
import java.util.HashMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.FieldError;
import com.giovane.soccer.exceptions.notfound.NotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import com.giovane.soccer.exceptions.details.ExceptionDetailsNotFound;
import com.giovane.soccer.exceptions.details.ExceptionDetailsBadRequest;
import com.giovane.soccer.exceptions.details.ExceptionMethodNotValidDetails;
import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ExceptionDetailsNotFound handlerNotFoundException(NotFoundException e){
       return ExceptionDetailsNotFound.builder()
                .status(NOT_FOUND.value())
                .title("Not found")
                .timestamp(Instant.now())
                .details(e.getMessage())
                .developerMessage("Include a valid ID. Make sure it exists.")
                .build();

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ExceptionMethodNotValidDetails handlerMethodNotValid(MethodArgumentNotValidException e){
        Map<String, String> error = new HashMap<>();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        fieldErrors.forEach(p -> error.put(p.getField(), p.getDefaultMessage()));

        return ExceptionMethodNotValidDetails.builder()
                .status(BAD_REQUEST.value())
                .title("Body contains invalid JSON")
                .timestamp(Instant.now())
                .details(error)
                .developerMessage("Error! Check the body constraints.")
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(BAD_REQUEST)
    public ExceptionDetailsBadRequest handlerBadRequest(){
       return ExceptionDetailsBadRequest.builder()
                .status(BAD_REQUEST.value())
                .title("Bad request")
                .timestamp(Instant.now())
                .details("You sent a request that this server didn't understand")
                .developerMessage("Check the request")
                .build();
    }

}
