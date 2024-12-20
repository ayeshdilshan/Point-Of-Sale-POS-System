package com.example.demo.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

public class CommonResponse {

    private HttpStatus status;
    private String message;
    private Object data;

//    // Getter and setter for status
    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    // Getter and setter for message
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Getter and setter for data
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
