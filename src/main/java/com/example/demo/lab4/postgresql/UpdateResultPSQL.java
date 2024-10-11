package com.example.demo.lab4.postgresql;

public class UpdateResultPSQL {
    private final boolean success;
    private final String message;
    private final UserPSQL updatedUser;

    public UpdateResultPSQL(boolean success, String message, UserPSQL updatedUser) {
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

    public UserPSQL getUpdatedUser() {
        return updatedUser;
    }
}
