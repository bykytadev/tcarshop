package com.project.tcarshop.exception;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ErrorResponse {
    private final String timestamp = LocalDateTime.now().toString();
    private final String message;
    private Map<String, String> errors;

    public ErrorResponse(String message, Map<String, String> errors) {
        this(message);
        this.errors = errors;
    }
}