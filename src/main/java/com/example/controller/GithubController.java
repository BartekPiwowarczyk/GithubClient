package com.example.controller;

import com.example.model.dto.RepoDto;
import com.example.webClient.dto.GithubRepoDto;
import com.example.service.GithubService;
import com.example.webClient.GithubClient;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.io.Serializable;
import java.util.List;

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Path("/api")
public class GithubController implements Serializable {

    @Inject
    GithubService githubService;

    @GET
    @Path("/users/{name}")
    public List<RepoDto> getRepositoriesForUser(@PathParam("name") String name) {
        return githubService.getRepositoriesForUser(name);
    }



}
