package com.nomal.pharmacy.core.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
public class ErrorObject {

    private final HttpStatus httpStatus;
    private final Integer statusCode;
    private final String message;
    private final ZonedDateTime zonedDateTime;



}
