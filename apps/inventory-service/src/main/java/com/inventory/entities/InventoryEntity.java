package com.inventory.entities;

import com.inventory.dtos.InventoryRequestDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "inventory")
public class InventoryEntity {

    @Id
    private Long id;

    @Column("product_id")
    private Long productId;

    private int quantity;


    public InventoryEntity() {
    }

    public InventoryEntity(Long id, Long productId, int quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    public InventoryEntity(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public InventoryRequestDTO toDTO() {
        return new InventoryRequestDTO(this.getId(), this.getProductId(), quantity);
    }
}
