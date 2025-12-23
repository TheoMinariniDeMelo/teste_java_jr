package com.coupon.domain.coupon;

import java.util.Optional;
import java.util.UUID;

public interface CouponRepository {
    void deactivate(UUID code);
    boolean existsByCodeAndStatus(String code, CouponStatus status);
    void save(Coupon coupon);
    Optional<Coupon> getByIdAndStatus(UUID id, CouponStatus status);
    boolean existsByIdAndStatus(UUID id, CouponStatus status);
}
