package com.retailer.rewards.exception;

import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends RestException {
    public CustomerNotFoundException(String message) {
        super(message);
        this.withHttpStatus(HttpStatus.NOT_FOUND.value());
    }
}
