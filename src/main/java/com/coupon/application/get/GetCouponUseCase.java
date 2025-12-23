package com.coupon.application.get;

import com.coupon.application.NotFoundException;
import com.coupon.domain.coupon.Coupon;
import com.coupon.domain.coupon.CouponRepository;
import com.coupon.domain.coupon.CouponStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GetCouponUseCase {

    private final CouponRepository couponRepository;
    private static final Logger log =
            LoggerFactory.getLogger(GetCouponUseCase.class);

    public GetCouponUseCase(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon execute(GetCouponCommand command) {
        log.info("Obtendo cupom: {}", command.id());

        var coupon = couponRepository.getByIdAndStatus(command.id(), CouponStatus.ACTIVE);

        if(coupon.isEmpty()){
            log.info("Cupom não encontrado {}", command.id());
            throw new NotFoundException("Cupom não encontrado");
        }
        log.info("Cupom obtido com sucesso {}", command.id());
        return coupon.get();
    }
}