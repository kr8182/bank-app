package ru.kr8182.bankapp.exceptions;

import java.time.LocalDateTime;

public record ErrorResponse (int status, String message, LocalDateTime timestamp) {
    public ErrorResponse(int status, String message) {
        this(status, message, LocalDateTime.now());
    }
}
