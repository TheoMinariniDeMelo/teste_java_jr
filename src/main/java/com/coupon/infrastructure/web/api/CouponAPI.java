package com.coupon.infrastructure.web.api;

import com.coupon.infrastructure.dto.CouponDTO;
import io.swagger.v3.oas.annotations.media.Content;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping(
        value = "/coupons",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public interface CouponAPI {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a coupon")
    @ApiResponses({
            @ApiResponse(responseCode = "201"),
            @ApiResponse(
                    responseCode = "422",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                    responseCode = "500",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            )
    })
    ResponseEntity<Void> createCoupon(
            @Valid @RequestBody CouponDTO couponDTO
    );

    @DeleteMapping("/{code}")
    @Operation(summary = "Delete a coupon")
    @ApiResponses({
            @ApiResponse(responseCode = "204"),
            @ApiResponse(
                    responseCode = "404",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                    responseCode = "500",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            )
    })
    ResponseEntity<Void> deleteCoupon(
            @PathVariable String code
    );
}
