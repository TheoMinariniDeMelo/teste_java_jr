package com.coupon.infrastructure.models.persistence;

import com.coupon.domain.Coupon;
import com.coupon.domain.CouponRepository;
import com.coupon.infrastructure.models.CouponModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CouponJpaRepository implements CouponRepository {
    private final SpringDataCouponRepository repository;

    public CouponJpaRepository(SpringDataCouponRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Coupon> findByCodeAndIsActiveTrue(String code) {
        return repository.findByCodeAndIsActiveTrue(code);
    }

    @Override
    public void deactivate(String code) {
        repository.deactivate(code);
    }

    @Override
    public Optional<Coupon> findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public boolean existsByCode(String code) {
        return repository.existsById(code);
    }

    @Override
    public boolean existsByCodeAndIsActiveTrue(String code) {
        return repository.existsByCodeAndIsActiveTrue(code);
    }

    @Override
    public void save(Coupon coupon) {
        repository.save(CouponModel.fromDomain(coupon));
    }
}
