package com.example.webClient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GithubRepoDto(String name, GithubOwnerDto owner) {
}
