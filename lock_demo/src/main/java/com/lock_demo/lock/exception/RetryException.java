package com.lock_demo.lock.exception;

//运行时异常
public class RetryException extends RuntimeException {
    public RetryException(String message) {
        super(message);
    }
}