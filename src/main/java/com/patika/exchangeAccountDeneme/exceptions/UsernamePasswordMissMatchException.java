package com.patika.exchangeAccountDeneme.exceptions;

public class UsernamePasswordMissMatchException extends RuntimeException{
    public UsernamePasswordMissMatchException(String message) {
        super(message);
    }
}
