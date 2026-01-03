package com.example.student.response;

import java.time.Instant;

public class ApiResponse<T> {
    private boolean success ;
    private int status;
    private String message;
    private T data;
    private Object errors;
    private String path;
    private Instant timestamp;

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public Object getErrors() { return errors; }
    public void setErrors(Object errors) { this.errors = errors; }

    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }

    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }

    public static <T>  ApiResponse<T> success(int status, String message, T data, String path) {
        ApiResponse<T> response = new ApiResponse<>();
        response.success = true;
        response.status = status;
        response.message = message;
        response.data = data;
        response.path = path;
        response.timestamp = Instant.now();
        return response;
    }

    public static <T> ApiResponse<T> failure(int status, String message, Object errors, String path) {
        ApiResponse<T> response = new ApiResponse<>();
        response.success = false;
        response.status = status;
        response.message = message;
        response.errors = errors;
        response.path = path;
        response.timestamp = Instant.now();
        return response;
    }




}
