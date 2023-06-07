package com.example.common.exception;

import java.io.Serializable;

public class GithubException extends RuntimeException implements Serializable {
    private Long status;

    public GithubException() {
    }

    public GithubException(String message) {
        super(message);
    }

    public GithubException(String message, Long status) {
        super(message);
        this.status = status;
    }
}
