package com.coupon;

import com.coupon.domain.coupon.Coupon;
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

    @Test
    void should_throw_error_when_expiration_date_is_in_the_past() {
        Coupon coupon = new Coupon(
                "ABC123",
                "Test coupon",
                LocalDate.now().minusDays(1),
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

        assertEquals("expirationDate", exception.getErrors().get(0).field());
    }

    @Test
    void should_throw_error_when_discount_is_less_than_minimum() {
        Coupon coupon = new Coupon(
                "ABC123",
                "Test coupon",
                LocalDate.now().plusDays(1),
                0.3,
                LocalDateTime.now(),
                LocalDateTime.now(),
                null,
                true
        );

        DomainException exception = assertThrows(
                DomainException.class,
                coupon::validation
        );

        assertEquals("discountValue", exception.getErrors().get(0).field());
    }

    @Test
    void should_return_all_errors_at_once() {
        Coupon coupon = new Coupon(
                "AB",
                "Test coupon",
                LocalDate.now().minusDays(1),
                0.1,
                LocalDateTime.now(),
                LocalDateTime.now(),
                null,
                true
        );

        DomainException exception = assertThrows(
                DomainException.class,
                coupon::validation
        );

        assertEquals(3, exception.getErrors().size());

        assertTrue(
                exception.getErrors().stream()
                        .anyMatch(e -> e.field().equals("code"))
        );
        assertTrue(
                exception.getErrors().stream()
                        .anyMatch(e -> e.field().equals("expirationDate"))
        );
        assertTrue(
                exception.getErrors().stream()
                        .anyMatch(e -> e.field().equals("discountValue"))
        );
    }

    @Test
    void should_not_throw_exception_when_coupon_is_valid() {
        Coupon coupon = new Coupon(
                "ABC123",
                "Valid coupon",
                LocalDate.now().plusDays(10),
                1.5,
                LocalDateTime.now(),
                LocalDateTime.now(),
                null,
                true
        );

        assertDoesNotThrow(coupon::validation);
    }
}
