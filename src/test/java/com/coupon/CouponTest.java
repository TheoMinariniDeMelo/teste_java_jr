package com.coupon;

import com.coupon.domain.DomainException;
import com.coupon.domain.coupon.Coupon;
import com.coupon.domain.coupon.CouponStatus;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class CouponTest {

    @Test
    void shouldValidateSuccessfully() {
        Coupon coupon = new Coupon(
                UUID.randomUUID(),
                "ABC123",
                "Desconto teste",
                LocalDateTime.now().plusDays(1),
                10.0,
                CouponStatus.ACTIVE,
                true,
                false
        );

        assertDoesNotThrow(coupon::validation);
    }

    @Test
    void shouldFailValidationWhenCodeIsInvalid() {
        Coupon coupon = new Coupon(
                UUID.randomUUID(),
                "ABC",
                "Desconto teste",
                LocalDateTime.now().plusDays(1),
                10.0,
                CouponStatus.ACTIVE,
                true,
                false
        );

        DomainException exception = assertThrows(DomainException.class, coupon::validation);
        assertTrue(exception.getErrors().stream()
                .anyMatch(e -> e.field().equals("code")));
    }

    @Test
    void shouldFailValidationWhenExpirationDateIsPast() {
        Coupon coupon = new Coupon(
                UUID.randomUUID(),
                "ABC123",
                "Desconto teste",
                LocalDateTime.now().minusDays(1),
                10.0,
                CouponStatus.ACTIVE,
                true,
                false
        );

        DomainException exception = assertThrows(DomainException.class, coupon::validation);
        assertTrue(exception.getErrors().stream()
                .anyMatch(e -> e.field().equals("expirationDate")));
    }

    @Test
    void shouldFailValidationWhenDiscountValueIsTooLow() {
        Coupon coupon = new Coupon(
                UUID.randomUUID(),
                "ABC123",
                "Desconto teste",
                LocalDateTime.now().plusDays(1),
                0.1,
                CouponStatus.ACTIVE,
                true,
                false
        );

        DomainException exception = assertThrows(DomainException.class, coupon::validation);
        assertTrue(exception.getErrors().stream()
                .anyMatch(e -> e.field().equals("discountValue")));
    }

    @Test
    void shouldFailValidationWithMultipleErrors() {
        Coupon coupon = new Coupon(
                UUID.randomUUID(),
                "A1",
                "Desconto teste",
                LocalDateTime.now().minusDays(1),
                0.1,
                CouponStatus.ACTIVE,
                true,
                false
        );

        DomainException exception = assertThrows(DomainException.class, coupon::validation);
        assertEquals(3, exception.getErrors().size());
    }
}
