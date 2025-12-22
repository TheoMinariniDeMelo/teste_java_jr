package com.coupon.domain;

import java.util.List;

public class DomainException extends RuntimeException {
    private List<DomainError> errors;

    public DomainException(List<DomainError> errors) {
        super("Erro ao validar dominio");
        this.errors = errors;
    }

    public List<DomainError> getErrors() {
        return errors;
    }
}
