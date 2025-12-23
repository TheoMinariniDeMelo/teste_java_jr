package com.coupon.infrastructure.models.persistence;

import com.coupon.domain.coupon.Coupon;
import com.coupon.domain.coupon.CouponRepository;
import com.coupon.domain.coupon.CouponStatus;
import com.coupon.infrastructure.models.CouponModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class CouponJpaRepository implements CouponRepository {
    private final SpringDataCouponRepository repository;

    public CouponJpaRepository(SpringDataCouponRepository repository) {
        this.repository = repository;
    }

    @Override
    public void deactivate(UUID id) {
        repository.deactivate(id);
    }

    @Override
    public boolean existsByCodeAndStatus(String code, CouponStatus status) {
        return repository.existsByCodeAndStatus(code, status);
    }

    @Override
    public boolean existsByIdAndStatus(UUID id, CouponStatus status){
        return repository.existsByIdAndStatus(id, status);
    }
    @Override
    public Optional<Coupon> getByIdAndStatus(UUID id, CouponStatus status){
        return repository.getByIdAndStatus(id, status);
    }

    @Override
    public void save(Coupon coupon) {
        repository.save(CouponModel.fromDomain(coupon));
    }

}
