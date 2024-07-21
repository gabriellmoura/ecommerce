package com.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.order.entity.OrderEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record OrderDTO(
        UUID id,

        @NotNull(message = "product_id must be fulfilled.") @JsonProperty("product_id")
        Long productId,

        @NotNull(message = "quantity must be fulfilled and greater than zero (0).")
        @Positive(message = "quantity must be positive.")
        int quantity
) {

    public OrderEntity toEntity() {
        return new OrderEntity(this.productId(), this.quantity());
    }
}
