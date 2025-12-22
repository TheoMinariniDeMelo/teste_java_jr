package com.coupon.infrastructure.models;

import com.coupon.dominio.Coupon;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "coupons")
@Getter
@Setter
public class CouponModel {
    @Id
    @Column(columnDefinition = "CHAR(6)", nullable = false)
    private String code;
    @Column(nullable = true)
    private String description;
    @Column(nullable = false)
    private LocalDate expirationDate;
    @Column(nullable = false)
    private Double discountValue;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;
    @Column(nullable = true)
    private LocalDateTime deletedAt;
    @Column(nullable = false)
    private Boolean isActive;

    public CouponModel() {
    }
    public CouponModel(String code, String description, LocalDate expirationDate, Double discountValue, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, Boolean isActive) {
        this.code = code;
        this.description = description;
        this.expirationDate = expirationDate;
        this.discountValue = discountValue;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.isActive = isActive;
    }
    public static CouponModel fromDomain(Coupon coupon) {
        return new CouponModel(
                coupon.getCode(),
                coupon.getDescription(),
                coupon.getExpirationDate(),
                coupon.getDiscountValue(),
                coupon.getCreatedAt(),
                coupon.getUpdatedAt(),
                coupon.getDeletedAt(),
                coupon.getIsActive()
        );
    }
}
