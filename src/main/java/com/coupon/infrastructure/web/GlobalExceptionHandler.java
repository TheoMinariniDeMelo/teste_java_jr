package com.coupon.infrastructure.web;

import com.coupon.application.BusinessException;
import com.coupon.application.NotFoundException;
import com.coupon.domain.DomainException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<DomainErrorResponse> handleDomainException(
            DomainException ex
    ) {
        String traceId = UUID.randomUUID().toString();

        log.warn(
                "Erro de domínio | traceId={} | errors={}",
                traceId,
                ex.getErrors()
        );

        return ResponseEntity
                .unprocessableEntity()
                .body(new DomainErrorResponse(
                                ex.getErrors(),
                                traceId
                        ));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(
            BusinessException ex
    ) {
        String traceId = UUID.randomUUID().toString();

        log.warn(
                "Erro de negócio | traceId={} | message={}",
                traceId,
                ex.getMessage()
        );

        return ResponseEntity
                .unprocessableEntity()
                .body(new ErrorResponse(
                        ex.getMessage(),
                        traceId
                ));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(
            NotFoundException ex
    ) {
        String traceId = UUID.randomUUID().toString();

        log.warn(
                "Recurso não encontrado | traceId={} | message={}",
                traceId,
                ex.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("Não encontrado", traceId));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(
            RuntimeException ex
    ) {
        String traceId = UUID.randomUUID().toString();

        log.error(
                "Erro interno inesperado | traceId={}",
                traceId,
                ex
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(
                        "Erro interno inesperado",
                        traceId
                ));
    }
}