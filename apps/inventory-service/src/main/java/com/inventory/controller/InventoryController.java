package com.inventory.controller;

import com.inventory.dtos.InventoryRequestDTO;
import com.inventory.services.InventoryService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/inventory")
@Validated
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @PostMapping
    public Mono<InventoryRequestDTO> save(@Valid @RequestBody InventoryRequestDTO requestDTO) {
        return service.save(requestDTO);
    }

    @PutMapping("/{id}")
    public Mono<InventoryRequestDTO> update(@PathVariable(name = "id") Long id,
                                           @Valid @RequestBody InventoryRequestDTO requestDTO) {
        return service.update(id, requestDTO);
    }

    @GetMapping("/{id}")
    public Mono<InventoryRequestDTO> findById(@PathVariable(name = "id") Long productId) {
        return service.findById(productId);
    }

    @GetMapping("/product_id/{id}")
    public Mono<InventoryRequestDTO> findByProductId(@PathVariable(name = "id") Long productId) {
        return service.findByProductId(productId);
    }

    @GetMapping
    public Flux<InventoryRequestDTO> findAll() {
        return service.findAll();
    }


}
