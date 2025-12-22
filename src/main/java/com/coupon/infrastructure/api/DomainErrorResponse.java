package com.coupon.infrastructure.api;

import com.coupon.dominio.DomainError;

import java.util.List;

public record DomainErrorResponse(
        List<DomainError> errors
) {}