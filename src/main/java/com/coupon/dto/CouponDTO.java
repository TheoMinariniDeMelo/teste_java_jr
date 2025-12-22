package com.coupon.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import org.h2.api.DatabaseEventListener;

import java.util.Date;

public record CouponDTO (
        @NotBlank
        String code,
        @NotBlank
        String description,
        @NotBlank
        Double discountValue,
        @FutureOrPresent
        Date expirationDate){
}
