package com.nomal.pharmacy.core.exception;

public class StockQuantityOutOfBountException extends RuntimeException{

    public StockQuantityOutOfBountException(String message) {
        super(message);
    }
}
