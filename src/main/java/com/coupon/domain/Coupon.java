package com.coupon.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
public class Coupon {

    private String code;
    private String description;
    private LocalDate expirationDate;
    private Double discountValue;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private Boolean isActive;

    public Coupon(String code, String description, LocalDate expirationDate, Double discountValue, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, Boolean isActive) {
        this.code = code;
        this.description = description;
        this.expirationDate = expirationDate;
        this.discountValue = discountValue;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.isActive = isActive;
    }
    public void validation(){
        ArrayList<DomainError> errors = new ArrayList<>();
        if(code.length() != 6){
            errors.add(new DomainError("code","Deve ter exatamente 6 caracteres"));
        }
        if(expirationDate.isBefore(LocalDate.now())){
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
