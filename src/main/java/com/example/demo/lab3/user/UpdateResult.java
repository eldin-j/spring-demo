package com.example.demo.lab3.user;

public class UpdateResult {
    private final boolean success;
    private final String message;
    private final User updatedUser;

    public UpdateResult(boolean success, String message, User updatedUser) {
        this.success = success;
        this.message = message;
        this.updatedUser = updatedUser;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public User getUpdatedUser() {
        return updatedUser;
    }
}
