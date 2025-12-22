package com.coupon.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "coupons")
public class CouponModel {
    @Id
    @Column(columnDefinition = "CHAR(6)", nullable = false)
    private String code;
    @Column(nullable = true)
    private String description;
    @Column(nullable = false)
    private Date expirationDate;
    @Column(nullable = false)
    private Double discountValue;
    @Column(nullable = false)
    private Date createdAt;
    @Column(nullable = false)
    private Date updatedAt;
    @Column(nullable = true)
    private Date deletedAt;
    @Column(nullable = false)
    private Boolean isActive;

    public CouponModel() {
    }
    public CouponModel(String code, String description, Date expirationDate, Double discountValue, Date createdAt, Date updatedAt, Date deletedAt, Boolean isActive) {
        this.code = code;
        this.description = description;
        this.expirationDate = expirationDate;
        this.discountValue = discountValue;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.isActive = isActive;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    public Double getDiscountValue() {
        return discountValue;
    }
    public void setDiscountValue(Double discountValue) {
        this.discountValue = discountValue;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Date getDeletedAt() {
        return deletedAt;
    }
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
    public Boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
