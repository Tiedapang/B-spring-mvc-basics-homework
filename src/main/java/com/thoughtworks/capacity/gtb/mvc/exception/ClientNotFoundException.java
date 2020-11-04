package com.thoughtworks.capacity.gtb.mvc.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String message){
        super(message);
    }

}
