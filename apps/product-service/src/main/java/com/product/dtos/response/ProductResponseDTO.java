package com.product.dtos.response;

import com.product.entities.ProductEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductResponseDTO(
        Long id,
        @NotEmpty(message = "name must be fulfilled.") String name,
                         @NotNull(message = "price must be fulfilled.") BigDecimal price) {

    public ProductEntity toEntity() {
        return new ProductEntity(this.name(), this.price());
    }
}
