package com.coupon.application.delete;

import java.util.UUID;

public record DeleteCouponCommand(
        UUID id
) {}