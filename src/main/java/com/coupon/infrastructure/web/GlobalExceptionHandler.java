package com.coupon.infrastructure.web;

import com.coupon.application.BusinessException;
import com.coupon.application.NotFoundException;
import com.coupon.domain.DomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

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
    public ResponseEntity<BusinessErrorResponse> handleBusinessException(
            BusinessException ex
    ) {
        return ResponseEntity
                .unprocessableEntity()
                .body(new BusinessErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(
            NotFoundException ex
    ) {
        String traceId = UUID.randomUUID().toString();

        return ResponseEntity
                .notFound()
                .build();
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<InternalServerErrorResponse> handleRuntimeException(
            RuntimeException ex
    ) {
        String traceId = UUID.randomUUID().toString();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new InternalServerErrorResponse(
                        "Erro interno inesperado",
                        traceId
                ));
    }
}