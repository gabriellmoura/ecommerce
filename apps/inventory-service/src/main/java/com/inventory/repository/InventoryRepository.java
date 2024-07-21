package com.inventory.repository;

import com.inventory.entities.InventoryEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface InventoryRepository extends R2dbcRepository<InventoryEntity, Long> {


    Mono<InventoryEntity> findByProductId(Long productId);

//    @Modifying
//    @Query("insert into inventory (id, product_id, quantity) values (:#{#inventoryEntity.id}, :#{#inventoryEntity.productId}, :#{#inventoryEntity.quantity})")
//    Mono<InventoryEntity> save(final InventoryEntity inventoryEntity);
}
