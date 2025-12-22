package com.coupon.infrastructure.api.controllers;

import com.coupon.infrastructure.api.CouponAPI;
import com.coupon.infrastructure.dto.CouponDTO;
import com.coupon.infrastructure.models.persistence.CouponRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


public class CouponController implements CouponAPI {
    @Autowired
    private CouponRepository couponRepository;

    @Override
    public ResponseEntity<?> createCoupon(@Valid @RequestBody CouponDTO couponDTO) {
        try{
            String code = couponDTO.code().replaceAll("[^a-zA-Z0-9]+","");
            var couponModel = couponRepository.findByCode(code);
            if(couponModel.isPresent()){
                return ResponseEntity.badRequest().body("Cupom já cadastrado");
            }

            return null;
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao criar cupom");
        }
    }

    @Override
    public ResponseEntity<?> deleteCoupon(String code) {
        return null;
    }
}
