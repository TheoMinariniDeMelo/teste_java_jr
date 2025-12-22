package com.coupon.infrastructure.web;

public record InternalServerErrorResponse(
        String message,
        String traceId
        ) { }
