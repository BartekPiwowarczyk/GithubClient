package com.example.common.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.reactive.ClientWebApplicationException;

@Provider
public class ExceptionHandler implements ExceptionMapper<GithubException> {

    @Override
    public Response toResponse(GithubException exception) {
        return mapExceptionToResponse(exception);
    }

    private Response mapExceptionToResponse(Exception exception) {
        if (exception.getMessage().equalsIgnoreCase("userNotFound")) {
            return Response.status(404).entity(new ErrorMessage("User not found", 404L)).build();
        }

        else if (exception.getMessage().equalsIgnoreCase("wrongHeader")) {
            return Response.status(406).header(HttpHeaders.CONTENT_TYPE,"application/json").entity(new ErrorMessage("Wrong header", 406L)).build();
        }

        else {
            return Response.status(404).entity(exception.getMessage()).build();
        }
    }
}
