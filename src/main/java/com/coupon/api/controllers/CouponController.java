package com.coupon.api.controllers;

import com.coupon.api.CouponAPI;
import com.coupon.dto.CouponDTO;
import com.coupon.models.CouponModel;
import com.coupon.models.repositories.CouponRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


public class CouponController implements CouponAPI {
    @Autowired
    private CouponRepository couponRepository;

    @Override
    public ResponseEntity<?> createCoupon(@Valid @RequestBody CouponDTO couponDTO) {
    }

    @Override
    public ResponseEntity<?> deleteCoupon(String code) {
        return null;
    }
}
