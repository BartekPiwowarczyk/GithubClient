package com.example.common.exception;

public class ErrorMessage {

    private String message;
    private Long status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public ErrorMessage(String message, Long status) {
        this.message = message;
        this.status = status;
    }

    public ErrorMessage() {
    }

}
