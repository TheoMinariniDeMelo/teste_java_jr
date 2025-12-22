package com.coupon.infrastructure.api.controllers;

import com.coupon.application.BusinessException;
import com.coupon.infrastructure.api.BusinessExceptionResponse;
import com.coupon.infrastructure.api.DomainErrorResponse;
import com.coupon.dominio.DomainException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<DomainErrorResponse> handleDomainException(
            DomainException ex
    ) {
        return ResponseEntity
                .unprocessableEntity()
                .body(new DomainErrorResponse(ex.getErrors()));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BusinessExceptionResponse> handleDomainException(
            BusinessException ex
    ) {
        return ResponseEntity
                .unprocessableEntity()
                .body(new BusinessExceptionResponse(ex.getMessage()));
    }
}