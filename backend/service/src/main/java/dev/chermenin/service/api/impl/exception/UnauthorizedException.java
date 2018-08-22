package dev.chermenin.service.api.impl.exception;

import lombok.Getter;

@Getter
public class UnauthorizedException extends CustomException {
    public UnauthorizedException(String message) {
        super(message, 401);
    }
}
