package com.product.services;

import com.product.dtos.request.ProductRequestDTO;
import com.product.dtos.response.ProductResponseDTO;
import com.product.entities.ProductEntity;
import com.product.exceptions.InternalServerException;
import com.product.exceptions.NotFoundException;
import com.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Mono<ProductResponseDTO> save(ProductRequestDTO productRequestDTO) {
        log.info("Saving the product {}", productRequestDTO);
        return Mono.just(productRequestDTO)
                .map(ProductRequestDTO::toEntity)
                .flatMap(entity -> repository.save(entity))
                .map(ProductEntity::toDTO)
                .onErrorMap(ex -> {
                    log.error("Error while saving ProductRequestDTO {}", productRequestDTO, ex);
                    return new InternalServerException("Failed when persisting the product.");
                });
    }

    public Mono<ProductResponseDTO> update(Long id, ProductRequestDTO productRequestDTO) {
        log.info("Updating the product {}", productRequestDTO);
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException(String.format("Product with id %s not found.", id))))
                .flatMap(productEntity -> repository.save(productRequestDTO.toEntity(id)))
                .map(ProductEntity::toDTO);
    }

    public Mono<ProductResponseDTO> findById(Long id) {
        return repository.findById(id)
                .map(ProductEntity::toDTO)
                .switchIfEmpty(Mono.error(new NotFoundException(String.format("Product with id %s not found.", id))));
    }

    public Flux<ProductResponseDTO> findAll() {
        return repository.findAll()
                .map(ProductEntity::toDTO)
                .switchIfEmpty(Flux.just());
    }
}
