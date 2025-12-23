package com.coupon.application.create;

import com.coupon.application.BusinessException;
import com.coupon.domain.coupon.Coupon;
import com.coupon.domain.coupon.CouponRepository;
import com.coupon.domain.coupon.CouponStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateCouponUseCase {

    private final CouponRepository couponRepository;

    private static final Logger log =  LoggerFactory.getLogger(CreateCouponUseCase.class);

    public CreateCouponUseCase(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon execute(CreateCouponCommand command) {
        log.info("Criando cupom: {}", command.code());
        if (couponRepository.existsByCode(command.code())) {
            log.info("Cupom não encontrado {}", command.code());
            throw new BusinessException("Cupom já existe");
        }

        Coupon coupon = new Coupon(
                UUID.randomUUID(),
                command.code(),
                command.description(),
                command.expirationDate(),
                command.discountValue(),
                CouponStatus.ACTIVE,
                command.published(),
                false
        );
        coupon.validation();

        couponRepository.save(coupon);
        log.info("Cupom criado com sucesso {}", command.code());
        return coupon;
    }
}