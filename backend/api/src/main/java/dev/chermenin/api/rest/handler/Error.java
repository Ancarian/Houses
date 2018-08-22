package dev.chermenin.api.rest.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Error {
    private int statusCode;
    private String errorMessage;
}