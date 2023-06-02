package com.example.model.dto;

import java.util.List;

public record RepoDto(String repositoryName, String owner, List<BranchDto> branches) {
}
