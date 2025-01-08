package com.retailer.rewards.exception;

import org.springframework.http.HttpStatus;

/**
 * CustomerNotFoundException handling the customer runtime exceptions
 *
 * @author Venkat
 */
public class CustomerNotFoundException extends RestException {
    public CustomerNotFoundException(String message) {
        super(message);
        this.withHttpStatus(HttpStatus.NOT_FOUND.value());
    }
}
