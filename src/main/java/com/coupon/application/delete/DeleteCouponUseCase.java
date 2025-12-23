package com.coupon.application.delete;

import com.coupon.application.NotFoundException;
import com.coupon.domain.CouponRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteCouponUseCase {

    private final CouponRepository couponRepository;

    public DeleteCouponUseCase(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public void execute(DeleteCouponCommand command) {
        if (!couponRepository.existsByCodeAndIsActiveTrue(command.code())) {
            throw new NotFoundException("Cupom não encontrado");
        }
        couponRepository.deactivate(command.code());
    }
}