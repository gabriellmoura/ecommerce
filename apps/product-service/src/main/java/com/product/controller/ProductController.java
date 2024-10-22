package com.product.controller;

import com.product.dtos.request.ProductRequestDTO;
import com.product.dtos.response.ProductResponseDTO;
import com.product.services.ProductService;
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
@RequestMapping("/products")
@Validated
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Mono<ProductResponseDTO> save(@Valid @RequestBody ProductRequestDTO requestDTO) {
        return service.save(requestDTO);
    }

    @PutMapping("/{id}")
    public Mono<ProductResponseDTO> update(@PathVariable(name = "id") Long id,
                                           @Valid @RequestBody ProductRequestDTO requestDTO) {
        return service.update(id, requestDTO);
    }

    @GetMapping("/{id}")
    public Mono<ProductResponseDTO> findById(@PathVariable(name = "id") Long id) {
        return service.findById(id);
    }

    @GetMapping
    public Flux<ProductResponseDTO> findAll() {
        return service.findAll();
    }



}
