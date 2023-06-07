package com.example.controller;

import com.example.common.exception.ErrorMessage;
import com.example.common.exception.GithubException;
import com.example.service.GithubService;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.ClientWebApplicationException;

import java.io.Serializable;

@RequestScoped
@Path("/api")
public class GithubController implements Serializable {

    @Inject
    GithubService githubService;

    @GET
    @Path("/users/{name}")
    public Response getRepositoriesForUser(@HeaderParam("Accept") String accept, @PathParam("name") String name) {
        try {
            if(accept.equalsIgnoreCase("application/xml")) {
                return Response.status(406).header(HttpHeaders.CONTENT_TYPE,"application/json").entity(new ErrorMessage("Wrong header",406L)).build();
            }
            return Response.status(200).entity(githubService.getRepositoriesForUser(accept, name)).build();
        } catch (Exception e) {
            throw new GithubException();
        }
    }



}
