package com.example.service;

import com.example.model.dto.BranchDto;
import com.example.model.dto.RepoDto;
import com.example.model.mapper.BranchDtoMapper;
import com.example.model.mapper.RepoDtoMapper;
import com.example.webClient.dto.GithubBranchDto;
import com.example.webClient.dto.GithubRepoDto;
import com.example.webClient.GithubClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class GithubService {

    @RestClient
    GithubClient githubClient;

    @Inject
    RepoDtoMapper repoDtoMapper;


    public List<RepoDto> getRepositoriesForUser(String accept, String name) {
        List<GithubRepoDto> githubRepoDtos = githubClient.getGithubRepositories(accept, name);
        return githubRepoDtos.stream()
                .map(githubRepoDto -> repoDtoMapper.mapToRepoDto(githubRepoDto,githubClient.getGithubBranchesForRepository(accept,name, githubRepoDto.name())))
                .collect(Collectors.toList());
    }
}
