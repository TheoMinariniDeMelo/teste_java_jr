package com.coupon;

import com.coupon.domain.Coupon;
import com.coupon.domain.DomainException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class CouponTest {

    @Test
    void should_throw_error_when_code_has_not_6_characters() {
        Coupon coupon = new Coupon(
                "ABC",
                "Test coupon",
                LocalDate.now().plusDays(1),
                1.0,
                LocalDateTime.now(),
                LocalDateTime.now(),
                null,
                true
        );

        DomainException exception = assertThrows(
                DomainException.class,
                coupon::validation
        );

        assertEquals(1, exception.getErrors().size());
        assertEquals("code", exception.getErrors().get(0).field());
    }

}
