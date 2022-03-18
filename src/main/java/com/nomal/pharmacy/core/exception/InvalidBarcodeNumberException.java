package com.nomal.pharmacy.core.exception;

public class InvalidBarcodeNumberException extends RuntimeException{
    public InvalidBarcodeNumberException(String message) {
        super(message);
    }
}
