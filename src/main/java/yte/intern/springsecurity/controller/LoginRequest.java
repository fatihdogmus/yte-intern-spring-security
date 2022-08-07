package yte.intern.springsecurity.controller;

public record LoginRequest(
        String username,
        String password
) {
}
