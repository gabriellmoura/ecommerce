package com.product.dtos.request;

import com.product.entities.ProductEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequestDTO(Long id,
                                @NotEmpty(message = "name must be fulfilled.") String name,
                                @NotNull(message = "price must be fulfilled.") BigDecimal price) {

    public ProductEntity toEntity() {
        return new ProductEntity(this.id(), this.name(), this.price());
    }

    public ProductEntity toEntity(Long id) {
        return new ProductEntity(id, this.name(), this.price());
    }

}
