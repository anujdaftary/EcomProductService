package com.springboot.ecomproductservice.exceptions;

public class NotFoundException extends Exception {
    public NotFoundException(String message){
        super(message);
    }
}
