package com.order.controller;

import com.order.dto.OrderDTO;
import com.order.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/order")
@Validated
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> save(@RequestBody @Valid OrderDTO orderDTO) {
        return ResponseEntity.ok(service.save(orderDTO));
    }

    @GetMapping("/{id}")
    public OrderDTO findById(@PathVariable UUID id) {
        return service.findById(id);
    }
}
