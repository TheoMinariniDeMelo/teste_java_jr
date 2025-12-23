package com.coupon.domain.coupon;

import com.coupon.domain.DomainError;
import com.coupon.domain.DomainException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Getter
public class Coupon {
    private UUID id;
    private String code;
    private String description;
    private LocalDateTime expirationDate;
    private Double discountValue;
    private CouponStatus status;
    private Boolean published;
    private Boolean redeemed;

    public Coupon(UUID id, String code, String description, LocalDateTime expirationDate, Double discountValue, CouponStatus status, Boolean published, Boolean redeemed) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.expirationDate = expirationDate;
        this.discountValue = discountValue;
        this.status = status;
        this.published = published;
        this.redeemed = redeemed;
    }
    public void validation(){
        ArrayList<DomainError> errors = new ArrayList<>();
        if(code.length() != 6){
            errors.add(new DomainError("code","Deve ter exatamente 6 caracteres"));
        }
        if(expirationDate.isBefore(LocalDateTime.now())){
            errors.add(new DomainError("expirationDate", "Deve ser maior que a data atual"));
        }
        if(discountValue < 0.5){
            errors.add(new DomainError("discountValue", "Deve ser maior que 0.5"));
        }
        if(!errors.isEmpty()){
            throw new DomainException(errors);
        }
    }
}
