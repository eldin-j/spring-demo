package com.example.demo.lab4.postgresql;

public class DeleteResultPSQL {
    private final boolean success;
    private final String message;

    public DeleteResultPSQL(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
