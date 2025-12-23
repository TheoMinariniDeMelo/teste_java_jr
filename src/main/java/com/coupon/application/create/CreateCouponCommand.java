package com.coupon.application.create;

import java.time.LocalDateTime;

public record CreateCouponCommand(
        String code,
        String description,
        double discountValue,
        LocalDateTime expirationDate,
        Boolean published
) {}