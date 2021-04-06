package com.example.orangetest.exception;

public class ResourceNotFoundExcepation  extends RuntimeException {
    public ResourceNotFoundExcepation(String message) {
        super(message);
    }

    public ResourceNotFoundExcepation(String message, Throwable cause) {
        super(message, cause);
    }
}
