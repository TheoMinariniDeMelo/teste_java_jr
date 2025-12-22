package com.coupon.infrastructure.api.controllers;

import com.coupon.application.CreateCouponCommand;
import com.coupon.application.CreateCouponUseCase;
import com.coupon.dominio.DomainException;
import com.coupon.infrastructure.api.CouponAPI;
import com.coupon.infrastructure.dto.CouponDTO;
import com.coupon.infrastructure.models.persistence.CouponJpaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


public class CouponController implements CouponAPI {
    @Autowired
    private CouponJpaRepository couponRepository;
    @Autowired
    private CreateCouponUseCase createCouponUseCase;

    @Override
    public ResponseEntity<?> createCoupon(@Valid @RequestBody CouponDTO couponDTO) {
        String code = couponDTO.code().replaceAll("[^a-zA-Z0-9]+","");
        var command = new CreateCouponCommand(code, couponDTO.description(), couponDTO.discountValue(), couponDTO.expirationDate());

        createCouponUseCase.execute(command);
        return ResponseEntity.ok().body("Cupom criado com sucesso");
    }

    @Override
    public ResponseEntity<?> deleteCoupon(String code) {
        return null;
    }
}
