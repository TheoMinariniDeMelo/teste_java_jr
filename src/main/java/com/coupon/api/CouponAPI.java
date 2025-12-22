package com.coupon.api;

import com.coupon.dto.CouponDTO;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface CouponAPI {
    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a coupon", description = "Cria um novo cupom no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cupom criado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Um erro de validação foi lançado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<?> createCoupon(@Valid @RequestBody CouponDTO couponDTO);

    @DeleteMapping(value = "delete/{code}")
    @PostMapping(value = "delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete a coupon", description = "Cria um novo cupom no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cupom deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cupom não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<?> deleteCoupon(String code);
}
