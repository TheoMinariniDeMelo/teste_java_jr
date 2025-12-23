package com.coupon.application.delete;

import com.coupon.application.NotFoundException;
import com.coupon.domain.CouponRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DeleteCouponUseCase {

    private final CouponRepository couponRepository;
    private static final Logger log =
            LoggerFactory.getLogger(DeleteCouponUseCase.class);

    public DeleteCouponUseCase(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public void execute(DeleteCouponCommand command) {
        log.info("Deletando cupom: {}", command.code());
        if (!couponRepository.existsByCodeAndIsActiveTrue(command.code())) {
            log.info("Cupom não encontrado {}", command.code());
            throw new NotFoundException("Cupom não encontrado");
        }
        couponRepository.deactivate(command.code());
        log.info("Cupom deletado com sucesso {}", command.code());
    }
}