package com.example.common.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.reactive.ClientWebApplicationException;

@Provider
public class ExceptionHandler implements ExceptionMapper<GithubException> {

    @ConfigProperty(name = "knowledgefactory.custom.error.msg.usernotfound")
    String userNotFound;

    @Override
    public Response toResponse(GithubException exception) {
        Response errorResponse = mapExceptionToResponse(exception);
        return errorResponse;
    }

    private Response mapExceptionToResponse(Exception exception) {
        // Use response from WebApplicationException as they are
        if (exception instanceof WebApplicationException) {
            Response originalErrorResponse = ((WebApplicationException) exception).getResponse();
            return Response.fromResponse(originalErrorResponse)
                    .entity(exception.getMessage())
                    .build();
        }
        // Special mappings
        else if (exception instanceof ClientWebApplicationException) {
            return Response.status(404).entity(new ErrorMessage("User not found", 404L)).build();
        }
        return null;
    }

    //    @Override
//    public Response toResponse(NotFoundGithubException e) {
//        if(e.getMessage().equalsIgnoreCase("User not found"))
//            return Response.status(404).entity(new ErrorMessage(e.getMessage(), 404L)).build();
//        else {
//            return Response.status(406).entity(new ErrorMessage("cos",406L)).build();
//        }
//    }
}
