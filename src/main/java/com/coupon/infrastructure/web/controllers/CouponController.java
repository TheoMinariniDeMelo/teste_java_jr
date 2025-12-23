package com.coupon.infrastructure.web.controllers;

import com.coupon.application.create.CreateCouponCommand;
import com.coupon.application.create.CreateCouponUseCase;
import com.coupon.application.delete.DeleteCouponCommand;
import com.coupon.application.delete.DeleteCouponUseCase;
import com.coupon.application.get.GetCouponCommand;
import com.coupon.application.get.GetCouponUseCase;
import com.coupon.infrastructure.web.CouponResponse;
import com.coupon.infrastructure.web.api.CouponAPI;
import com.coupon.infrastructure.dto.CouponDTO;
import com.coupon.infrastructure.models.persistence.CouponJpaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CouponController implements CouponAPI {

    private final CreateCouponUseCase createCouponUseCase;
    private final DeleteCouponUseCase deleteCouponUseCase;
    private final GetCouponUseCase getCouponUseCase;

    public CouponController(
            CreateCouponUseCase createCouponUseCase,
            DeleteCouponUseCase deleteCouponUseCase,
            GetCouponUseCase getCouponUseCase
    ) {
        this.createCouponUseCase = createCouponUseCase;
        this.deleteCouponUseCase = deleteCouponUseCase;
        this.getCouponUseCase = getCouponUseCase;
    }

    @Override
    public ResponseEntity<CouponResponse> createCoupon(CouponDTO couponDTO) {
        String code = couponDTO.code().replaceAll("[^a-zA-Z0-9]+","");
        var command = new CreateCouponCommand(
                code,
                couponDTO.description(),
                couponDTO.discountValue(),
                couponDTO.expirationDate(),
                couponDTO.published()
        );
        var coupon = createCouponUseCase.execute(command);
        return ResponseEntity.status(201).body(new CouponResponse(coupon.getId().toString(), coupon.getCode(), coupon.getDescription(), coupon.getDiscountValue(), coupon.getStatus(), coupon.getExpirationDate(), coupon.getPublished(), coupon.getRedeemed()));
    }

    @Override
    public ResponseEntity<Void> deleteCoupon(UUID id) {
        deleteCouponUseCase.execute(new DeleteCouponCommand(id));
        return ResponseEntity.noContent().build();
    }
    @Override
    public ResponseEntity<CouponResponse> getCoupon(UUID id){
        var coupon = getCouponUseCase.execute(new GetCouponCommand(id));
        return ResponseEntity.ok(new CouponResponse(coupon.getId().toString(), coupon.getCode(), coupon.getDescription(), coupon.getDiscountValue(), coupon.getStatus(), coupon.getExpirationDate(), coupon.getPublished(), coupon.getRedeemed()));
    }
}
