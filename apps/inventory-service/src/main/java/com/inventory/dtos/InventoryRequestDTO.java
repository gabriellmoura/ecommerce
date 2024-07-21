package com.inventory.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inventory.entities.InventoryEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record InventoryRequestDTO(
        Long id,

        @NotNull(message = "product_id must be fulfiled.")
        @JsonProperty("product_id")
        Long productId,

        @NotNull(message = "quantity must be fulfilled and greater than zero (0).")
        @Positive(message = "quantity must be positive.")
        int quantity
) {

    public InventoryEntity toEntity() {
        return new InventoryEntity(this.productId(), this.quantity());
    }

    public InventoryEntity toEntity(Long id) {
        return new InventoryEntity(id, this.productId(), this.quantity());
    }
}
