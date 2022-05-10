package com.luxoftInterview.demo.model;

public class ReturnObject {

    private int status;

    private String message;

    public ReturnObject(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
