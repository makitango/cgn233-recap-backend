package com.example.cgn233recapbackend;

public record Task(String id, String description, TaskStatus status) {
    public Task {
        if (description == null || status == null) {
            throw new IllegalArgumentException("Description and status cannot be null");
        }
    }
}
