package com.example.service;

import com.example.model.dto.BranchDto;
import com.example.model.dto.RepoDto;
import com.example.webClient.dto.GithubBranchDto;
import com.example.webClient.dto.GithubRepoDto;
import com.example.webClient.GithubClient;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class GithubService {

    @RestClient
    GithubClient githubClient;

    public List<RepoDto> getRepositoriesForUser(String name) {
        List<GithubRepoDto> githubRepoDtos = githubClient.getGithubRepositories("application/json", name);
        return githubRepoDtos.stream()
                .map(githubRepoDto -> new RepoDto(
                        githubRepoDto.name(),
                        githubRepoDto.owner().login(),
                        githubClient.getGithubBranchesForRepository("application/json",name, githubRepoDto.name()).stream()
                                .map(githubBranchDto -> new BranchDto(
                                        githubBranchDto.name(),
                                        githubBranchDto.commit().sha()
                                )).collect(Collectors.toList())
                        )
                        )
                .collect(Collectors.toList());
    }

    private List<BranchDto> getBranchesForRepository(String name, String repositoryName) {
        return null;
    }
}
