package com.example.exambyte.users;

public record Role(String role) {
    @Override
    public String role() {
        return role;
    }
}
