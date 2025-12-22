package com.coupon.application;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
