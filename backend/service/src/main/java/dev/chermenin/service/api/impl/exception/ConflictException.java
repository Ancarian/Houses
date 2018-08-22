package dev.chermenin.service.api.impl.exception;

public class ConflictException extends CustomException {

    public ConflictException(String message) {
        super(message, 409);
    }
}
