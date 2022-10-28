package com.example.repository.search.exception;

public class ConnectionNotFoundException  extends  RuntimeException {
    private Exception message;

    public ConnectionNotFoundException() {}

    public ConnectionNotFoundException(Exception msg) {
        super(msg);
        this.message = msg;
    }
}
