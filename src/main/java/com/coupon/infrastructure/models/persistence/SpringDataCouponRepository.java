package com.coupon.infrastructure.models.persistence;

import com.coupon.domain.Coupon;
import com.coupon.infrastructure.models.CouponModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataCouponRepository extends JpaRepository<CouponModel, String> {
    Optional<Coupon> findByCodeAndIsActiveTrue(String code);

    @Modifying
    @Transactional
    @Query("update CouponModel c set c.isActive = false, c.updatedAt = CURRENT_TIMESTAMP, c.deletedAt = CURRENT_TIMESTAMP where c.code = :code")
    void deactivate(@Param("code") String code);

    Optional<Coupon> findByCode(String code);

    boolean existsByCodeAndIsActiveTrue(String code);
}
