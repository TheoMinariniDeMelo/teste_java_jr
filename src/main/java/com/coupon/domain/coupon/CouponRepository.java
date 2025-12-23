package com.coupon.domain.coupon;

import java.util.Optional;
import java.util.UUID;

public interface CouponRepository {
    void deactivate(UUID code);
    boolean existsByCode(String code);
    void save(Coupon coupon);
    Optional<Coupon> getByIdAndStatus(UUID id, CouponStatus status);
    boolean existsByIdAndStatus(UUID id, CouponStatus status);
}
