package com.example.model.mapper;

import com.example.model.dto.BranchDto;
import com.example.model.dto.RepoDto;
import com.example.webClient.dto.GithubBranchDto;
import com.example.webClient.dto.GithubRepoDto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;

@ApplicationScoped
public class BranchDtoMapper {

    public BranchDto mapToBranchDto(GithubBranchDto githubBranchDto) {
        return new BranchDto.Builder()
                .withName(githubBranchDto.name())
                .withSha(githubBranchDto.commit().sha())
                .build();
    }
}
