package com.order.configuration.feign.clients;

import com.order.exceptions.decoders.ProductServiceErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class InventoryServiceFeignSupportConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new ProductServiceErrorDecoder();
    }
}
