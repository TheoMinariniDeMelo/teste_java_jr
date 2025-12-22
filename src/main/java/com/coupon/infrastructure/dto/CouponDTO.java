package com.coupon.infrastructure.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Date;

public record CouponDTO (
        @NotBlank
        String code,
        @NotBlank
        String description,
        @NotBlank
        Double discountValue,
        @FutureOrPresent
        LocalDate expirationDate){
}
