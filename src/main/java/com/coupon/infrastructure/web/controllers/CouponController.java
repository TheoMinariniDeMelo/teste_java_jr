package com.coupon.infrastructure.web.controllers;

import com.coupon.application.create.CreateCouponCommand;
import com.coupon.application.create.CreateCouponUseCase;
import com.coupon.application.delete.DeleteCouponCommand;
import com.coupon.application.delete.DeleteCouponUseCase;
import com.coupon.infrastructure.web.CreateCouponResponse;
import com.coupon.infrastructure.web.api.CouponAPI;
import com.coupon.infrastructure.dto.CouponDTO;
import com.coupon.infrastructure.models.persistence.CouponJpaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController implements CouponAPI {

    private final CreateCouponUseCase createCouponUseCase;
    private final DeleteCouponUseCase deleteCouponUseCase;

    public CouponController(
            CreateCouponUseCase createCouponUseCase,
            DeleteCouponUseCase deleteCouponUseCase
    ) {
        this.createCouponUseCase = createCouponUseCase;
        this.deleteCouponUseCase = deleteCouponUseCase;
    }

    @Override
    public ResponseEntity<CreateCouponResponse> createCoupon(CouponDTO couponDTO) {
        String code = couponDTO.code().replaceAll("[^a-zA-Z0-9]+","");
        var command = new CreateCouponCommand(
                code,
                couponDTO.description(),
                couponDTO.discountValue(),
                couponDTO.expirationDate()
        );
        createCouponUseCase.execute(command);
        return ResponseEntity.status(201).body(new CreateCouponResponse(code));
    }

    @Override
    public ResponseEntity<Void> deleteCoupon(String code) {
        deleteCouponUseCase.execute(new DeleteCouponCommand(code));
        return ResponseEntity.noContent().build();
    }
}
