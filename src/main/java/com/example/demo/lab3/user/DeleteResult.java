package com.example.demo.lab3.user;

public class DeleteResult {
    private final boolean success;
    private final String message;
    private final User deletedUser;

    public DeleteResult(boolean success, String message, User deletedUser) {
        this.success = success;
        this.message = message;
        this.deletedUser = deletedUser;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public User getDeletedUser() {
        return deletedUser;
    }
}
