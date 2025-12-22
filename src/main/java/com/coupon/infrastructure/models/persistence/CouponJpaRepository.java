package com.coupon.infrastructure.models.persistence;

import com.coupon.dominio.Coupon;
import com.coupon.dominio.CouponRepository;
import com.coupon.infrastructure.models.CouponModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    public void save(Coupon coupon) {
        repository.save(CouponModel.fromDomain(coupon));
    }
}
