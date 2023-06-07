package com.example.model.dto;

import java.util.ArrayList;
import java.util.List;

public record RepoDto(String repositoryName, String owner, List<BranchDto> branches) {

    public static class Builder {
        private String repositoryName;
        private String owner;
        private List<BranchDto> branches = new ArrayList<>();

        public  Builder withRepositoryName(final String repositoryName) {
            this.repositoryName = repositoryName;
            return this;
        }

        public  Builder withOwner(final String owner) {
            this.owner = owner;
            return this;
        }

        public  Builder withBranches(final List<BranchDto> branches) {
            this.branches = branches;
            return this;
        }

       public RepoDto build() {
            return new RepoDto(repositoryName,owner,branches);
       }

    }
}

