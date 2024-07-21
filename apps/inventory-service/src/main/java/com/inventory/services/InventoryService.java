package com.inventory.services;

import com.inventory.entities.InventoryEntity;
import com.inventory.dtos.InventoryRequestDTO;
import com.inventory.exceptions.InternalServerException;
import com.inventory.exceptions.NotFoundException;
import com.inventory.repository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class InventoryService {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public Mono<InventoryRequestDTO> save(InventoryRequestDTO requestDTO) {
        return Mono.just(requestDTO)
                .map(InventoryRequestDTO::toEntity)
                .flatMap(inventoryEntity -> repository.save(inventoryEntity))
                .map(InventoryEntity::toDTO)
                .onErrorMap(ex -> {
                    log.error("Error while saving InventoryRequestDTO {}", requestDTO, ex);
                    return new InternalServerException("Failed when persisting the inventory");
                });
    }

    public Mono<InventoryRequestDTO> update(Long id, InventoryRequestDTO inventoryRequestDTO) {
        log.info("Updating the Inventory {}", inventoryRequestDTO);
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException(String.format("Inventory with id %s not found.", id))))
                .flatMap(inventoryEntity -> repository.save(inventoryRequestDTO.toEntity(id)))
                .map(InventoryEntity::toDTO);
    }


    public Mono<InventoryRequestDTO> findById(Long id) {
        return repository.findById(id)
                .map(InventoryEntity::toDTO)
                .switchIfEmpty(Mono.error(new NotFoundException(String.format("Inventory with id %s not found.", id))));
    }

    public Mono<InventoryRequestDTO> findByProductId(Long productId) {
        return repository.findByProductId(productId)
                .map(InventoryEntity::toDTO)
                .switchIfEmpty(Mono.error(new NotFoundException(String.format("Inventory with product_id %s not found.", productId))));
    }

    public Flux<InventoryRequestDTO> findAll() {
        return repository.findAll()
                .map(InventoryEntity::toDTO)
                .switchIfEmpty(Flux.just());
    }
}
