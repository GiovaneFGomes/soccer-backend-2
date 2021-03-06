package com.giovane.soccer.exceptions.details;

import java.time.Instant;
import java.util.Map;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class ExceptionMethodNotValidDetails {
    private Integer status;
    private String title;
    private Instant timestamp;
    private Map<String,String> details;
    private String developerMessage;
}
