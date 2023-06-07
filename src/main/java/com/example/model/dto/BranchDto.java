package com.example.model.dto;

import java.util.ArrayList;
import java.util.List;

public record BranchDto(String name, String sha) {
    public static class Builder {
        private String name;
        private String sha;

        public BranchDto.Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public BranchDto.Builder withSha(final String sha) {
            this.sha = sha;
            return this;
        }

        public BranchDto build() {
            return new BranchDto(name, sha);
        }
    }
}
