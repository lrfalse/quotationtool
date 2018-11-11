package com.commons.exception;

public class NotFoundException extends BusinessException {
    public NotFoundException(String message) {
        super(message, 404);
    }


}
