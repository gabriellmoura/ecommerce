package com.order.service;

import com.order.client.InventoryFeignClient;
import com.order.client.ProductFeignClient;
import com.order.dto.InventoryDTO;
import com.order.dto.OrderDTO;
import com.order.exceptions.BadRequestException;
import com.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {

    private final OrderRepository repository;

    private final InventoryFeignClient inventoryFeignClient;

    private final ProductFeignClient productFeignClient;

    public OrderService(OrderRepository repository, InventoryFeignClient inventoryFeignClient, ProductFeignClient productFeignClient) {
        this.repository = repository;
        this.inventoryFeignClient = inventoryFeignClient;
        this.productFeignClient = productFeignClient;
    }

    public OrderDTO save(OrderDTO orderDTO) {
        final var product = productFeignClient.findById(orderDTO.productId());
        final var inventory = inventoryFeignClient.findByProductId(product.id());

        if (orderDTO.quantity() > inventory.quantity()) {
            throw new BadRequestException(String.format("Product with id %s hasn't enough stock.", product.id()));
        }
        final var quantity = inventory.quantity() - orderDTO.quantity();
        final var inventoryRequest = new InventoryDTO(inventory.id(), inventory.productId(), quantity);
        final var inventoryUpdate = inventoryFeignClient.update(inventoryRequest.id(), inventoryRequest);
        log.info("Inventory updated sucessfully {} with quantity {} to product_id {}", inventoryUpdate, quantity,
                inventoryUpdate.productId());

        return repository.save(orderDTO.toEntity()).toDTO();
    }
}
