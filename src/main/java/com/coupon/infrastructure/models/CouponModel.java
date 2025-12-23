package com.coupon.infrastructure.models;

import com.coupon.domain.coupon.Coupon;
import com.coupon.domain.coupon.CouponStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "coupons")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CouponModel {
    @Id
    private UUID id;
    @Column(length = 6, nullable = false)
    private String code;
    @Column(nullable = true)
    private String description;
    @Column(nullable = false)
    private LocalDateTime expirationDate;
    @Column(nullable = false)
    private Double discountValue;
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private CouponStatus status;
    @Column(nullable = false)
    private Boolean published;
    @Column(nullable = false)
    private Boolean redeemed;

    public static CouponModel fromDomain(Coupon coupon) {
        return new CouponModel(
                coupon.getId(),
                coupon.getCode(),
                coupon.getDescription(),
                coupon.getExpirationDate(),
                coupon.getDiscountValue(),
                coupon.getStatus(),
                coupon.getPublished(),
                coupon.getRedeemed()
        );
    }
}
