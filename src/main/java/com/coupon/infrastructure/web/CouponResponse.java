package com.coupon.infrastructure.web;

import com.coupon.domain.coupon.CouponStatus;
import com.coupon.infrastructure.dto.CouponDTO;

import java.time.LocalDateTime;

public record CouponResponse(String id, String code, String description, double discountValue, CouponStatus status, LocalDateTime expirationDate, Boolean published, Boolean redeemed) {}