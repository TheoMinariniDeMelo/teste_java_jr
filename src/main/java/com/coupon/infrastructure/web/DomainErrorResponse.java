package com.coupon.infrastructure.web;

import com.coupon.domain.DomainError;

import java.util.List;

public record DomainErrorResponse(
        List<DomainError> errors,
        String traceId
) {}