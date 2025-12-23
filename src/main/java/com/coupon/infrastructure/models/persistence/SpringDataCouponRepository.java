package com.coupon.infrastructure.models.persistence;

import com.coupon.domain.coupon.Coupon;
import com.coupon.domain.coupon.CouponStatus;
import com.coupon.infrastructure.models.CouponModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringDataCouponRepository extends JpaRepository<CouponModel, String> {
    @Modifying
    @Transactional
    @Query("update CouponModel c set c.status = 2 where c.id = :id")
    void deactivate(@Param("id") UUID id);

    boolean existsByIdAndStatus(UUID id, CouponStatus status);

    Optional<Coupon> getByIdAndStatus(UUID id, CouponStatus status);

    boolean existsByCode(String code);
}
