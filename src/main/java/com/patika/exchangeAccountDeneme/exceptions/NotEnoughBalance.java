package com.patika.exchangeAccountDeneme.exceptions;

public class NotEnoughBalance extends RuntimeException{
    public NotEnoughBalance(String message) {
        super(message);
    }
}
