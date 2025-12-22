package com.coupon.application;

import java.time.LocalDate;

public record CreateCouponCommand(
        String code,
        String description,
        double discountValue,
        LocalDate expirationDate
) {}