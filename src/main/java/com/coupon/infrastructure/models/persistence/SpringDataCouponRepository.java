package com.coupon.infrastructure.models.persistence;

import com.coupon.dominio.Coupon;
import com.coupon.infrastructure.models.CouponModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataCouponRepository extends JpaRepository<CouponModel, String> {
    Optional<Coupon> findByCodeAndIsActiveTrue(String code);
    @Modifying
    @Query("update coupons c set c.isActive = false where c.code = :code")
    void deactivate(String code);

    Optional<Coupon> findByCode(String code);
}
