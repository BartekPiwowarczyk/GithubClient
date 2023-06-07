package com.example.webClient;

import com.example.webClient.dto.GithubBranchDto;
import com.example.webClient.dto.GithubRepoDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestHeader;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@RegisterRestClient(configKey = "github-client")
@Produces(MediaType.APPLICATION_JSON)
public interface GithubClient extends Serializable {

    @Path("/users/{name}/repos")
    @GET
    List<GithubRepoDto> getGithubRepositories(
            @HeaderParam("Accept") String accept,
            @PathParam("name") String name
    );

    @Path("/repos/{name}/{repositoryName}/branches")
    @GET
    List<GithubBranchDto> getGithubBranchesForRepository(
            @HeaderParam("Accept") String accept,
            @PathParam("name") String name,
            @PathParam("repositoryName") String repositoryName
    );
}
