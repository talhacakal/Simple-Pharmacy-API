package com.nomal.pharmacy.core.exception;

public class AlreadySoldException extends RuntimeException{

    public AlreadySoldException(String message){
        super(message);
    }
}
