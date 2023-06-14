package com.example.controller;

import com.example.common.exception.GithubException;
import com.example.service.GithubService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
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
    public Response getRepositoriesForUser(@HeaderParam("Accept") String accept, @PathParam("name") String name) throws GithubException {
        try {
            if (accept.equalsIgnoreCase("application/xml")) {
                throw new GithubException("wrongHeader");
            }
            return Response.status(200).entity(githubService.getRepositoriesForUser(accept, name)).build();
        } catch (ClientWebApplicationException e) {
            throw new GithubException("userNotFound");
        }
    }

}
