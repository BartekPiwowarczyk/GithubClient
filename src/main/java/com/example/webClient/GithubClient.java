package com.example.webClient;

import com.example.webClient.dto.GithubBranchDto;
import com.example.webClient.dto.GithubRepoDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.io.Serializable;
import java.util.List;

@RegisterRestClient(configKey = "github-client")
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
