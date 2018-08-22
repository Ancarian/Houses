package dev.chermenin.api.rest.handler;


import dev.chermenin.service.api.impl.exception.CustomException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable ex) {
        Error error = new Error(setHttpStatus(ex), ex.getMessage());
        return Response.status(error.getStatusCode())
                .entity(ex)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    private int setHttpStatus(Throwable ex) {
        if (ex instanceof CustomException) {
            return ((CustomException) ex).getStatusCode();
        } else {
            return Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        }
    }

}