package com.onlineshopping.userservice.exception;

public class UserAlreadyExist extends RuntimeException {

    public UserAlreadyExist() {
    }

    public UserAlreadyExist(String ex) {
        super(ex);
    }
}
