package dev.chermenin.service.api.impl.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private int statusCode;

    public CustomException(String message, int code) {
        super(message);
        statusCode = code;
    }
}
