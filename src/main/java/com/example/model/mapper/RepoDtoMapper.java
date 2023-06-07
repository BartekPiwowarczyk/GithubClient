package com.example.model.mapper;

import com.example.model.dto.BranchDto;
import com.example.model.dto.RepoDto;
import com.example.webClient.dto.GithubBranchDto;
import com.example.webClient.dto.GithubRepoDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class RepoDtoMapper {

    @Inject
    BranchDtoMapper branchDtoMapper;

   public RepoDto mapToRepoDto(GithubRepoDto githubRepoDto, List<GithubBranchDto> githubBranchDto) {
       return new RepoDto.Builder()
               .withRepositoryName(githubRepoDto.name())
               .withOwner(githubRepoDto.owner().login())
               .withBranches(mapToListBranchDto(githubBranchDto))
               .build();
   }

   private List<BranchDto> mapToListBranchDto(List<GithubBranchDto> branches) {
       return branches.stream()
               .map(branch -> branchDtoMapper.mapToBranchDto(branch))
               .collect(Collectors.toList());
   }
}
