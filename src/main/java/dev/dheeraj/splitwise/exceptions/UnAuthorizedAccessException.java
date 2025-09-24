package dev.dheeraj.splitwise.exceptions;

public class UnAuthorizedAccessException extends RuntimeException {
    public UnAuthorizedAccessException(String message) {
        super(message);
    }
}
