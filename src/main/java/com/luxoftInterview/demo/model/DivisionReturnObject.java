package com.luxoftInterview.demo.model;

public class DivisionReturnObject extends ReturnObject {

    private int status;

    private Division division;

    public DivisionReturnObject(int status, Division division) {
        super(status);
        this.status = status;
        this.division = division;
    }

    public int getStatus() {
        return status;
    }

    public Division getDivision() {
        return division;
    }
}
