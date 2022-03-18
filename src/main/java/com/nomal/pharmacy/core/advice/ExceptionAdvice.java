package com.nomal.pharmacy.core.advice;

import com.nomal.pharmacy.core.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = {RecordNotFoundException.class})
    public ResponseEntity<ErrorObject> handleRecordNotFoundException(RecordNotFoundException exception){
        ErrorObject errorObject = new ErrorObject(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), exception.getMessage(), ZonedDateTime.now(ZoneId.of("Europe/Istanbul")));

        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = {AlreadyExistsException.class})
    public ResponseEntity<ErrorObject> handleAlreadyExistsException(AlreadyExistsException exception){
        ErrorObject errorObject = new ErrorObject(HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(), exception.getMessage(), ZonedDateTime.now(ZoneId.of("Europe/Istanbul")));

        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({InvalidBarcodeNumberException.class, AlreadySoldException.class, StockQuantityOutOfBountException.class})
    public ResponseEntity<ErrorObject> handleBadRequest(RuntimeException exception){
        ErrorObject errorObject = new ErrorObject(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), exception.getMessage(), ZonedDateTime.now(ZoneId.of("Europe/Istanbul")));

        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorObject> handleConstraintViolationException(ConstraintViolationException exception){
        ErrorObject errorObject = new ErrorObject(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), exception.getMessage(), ZonedDateTime.now(ZoneId.of("Europe/Istanbul")));
        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorObject> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ObjectError> list =  ex.getBindingResult().getAllErrors();
        String message = list.get(list.size()-1).getDefaultMessage();

        ErrorObject errorObject = new ErrorObject(
                HttpStatus.BAD_REQUEST,
                HttpStatus.BAD_REQUEST.value(),
                message,
                ZonedDateTime.now(ZoneId.of("Europe/Istanbul")));
        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ErrorObject> handleNumberFormatException(NumberFormatException ex) {
        ErrorObject errorObject = new ErrorObject(
                HttpStatus.BAD_REQUEST,
                HttpStatus.BAD_REQUEST.value(),
                ex.getLocalizedMessage(),
                ZonedDateTime.now(ZoneId.of("Europe/Istanbul")));
        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErrorObject> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        ErrorObject errorObject = new ErrorObject(
                HttpStatus.INTERNAL_SERVER_ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                e.getMessage(),
                ZonedDateTime.now(ZoneId.of("Europe/Istanbul")));
        return new ResponseEntity<>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
