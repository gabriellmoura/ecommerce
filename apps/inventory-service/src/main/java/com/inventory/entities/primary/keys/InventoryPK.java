package com.inventory.entities.primary.keys;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class InventoryPK implements Serializable {

    private Long id;

    private Long productId;

    public InventoryPK() {
    }

    public InventoryPK(Long productId) {
        this.productId = productId;
    }

    public InventoryPK(Long id, Long productId) {
        this.id = id;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
