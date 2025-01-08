package com.retailer.rewards.exception;

import org.springframework.http.HttpStatus;

/**
 * RestException class is contains the exception details
 *
 * @author Venkat
 */
public class RestException extends RuntimeException {
    private static final long serialVersionUID = -7105919687668262163L;
    private String referenceId;
    private HttpStatus status;

    public RestException() {
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public RestException(String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public String getReferenceId() {
        return this.referenceId;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public RestException withReferenceId(String referenceId) {
        this.referenceId = referenceId;
        return this;
    }

    public RestException withHttpStatus(int statusCode) {
        try {
            this.status = HttpStatus.valueOf(statusCode);
        } catch (IllegalArgumentException var3) {
        }

        return this;
    }

}
