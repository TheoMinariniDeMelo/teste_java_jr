package com.coupon.dominio;

import java.util.Optional;

public interface CouponRepository {
    Optional<Coupon> findByCodeAndIsActiveTrue(String code);
    void deactivate(String code);
    Optional<Coupon> findByCode(String code);
    boolean existsByCode(String code);
    void save(Coupon coupon);
}
