package com.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record InventoryDTO(
        Long id,

        @JsonProperty("product_id")
        Long productId,

        int quantity
) {

    public int updateQuantity(int quantity) {
        return this.quantity() - quantity;
    }
}
