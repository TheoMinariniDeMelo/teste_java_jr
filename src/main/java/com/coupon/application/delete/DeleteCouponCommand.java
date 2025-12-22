package com.coupon.application.delete;

import java.time.LocalDate;

public record DeleteCouponCommand(
        String code
) {}