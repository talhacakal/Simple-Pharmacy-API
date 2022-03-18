package com.nomal.pharmacy.core.exception;

public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException(String message){
        super(message);
    }
}
