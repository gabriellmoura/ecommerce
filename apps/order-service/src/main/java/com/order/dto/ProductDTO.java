package com.order.dto;

import java.math.BigDecimal;

public record ProductDTO(Long id,
                         String name,
                         BigDecimal price) {
}
