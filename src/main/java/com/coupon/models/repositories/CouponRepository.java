package com.coupon.models.repositories;

import com.coupon.models.CouponModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<CouponModel, String> {
    Optional<CouponModel> findByCodeAndIsActiveTrue(String code);

    @Modifying
    @Query("UPDATE coupons c SET c.isActive = false WHERE c.code = :id")
    void deactivate(@Param("code") String code);
}
