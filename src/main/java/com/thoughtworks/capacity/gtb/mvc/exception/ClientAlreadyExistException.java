package com.thoughtworks.capacity.gtb.mvc.exception;

public class ClientAlreadyExistException extends RuntimeException {
    public ClientAlreadyExistException(String message){
        super(message);
    }

}
