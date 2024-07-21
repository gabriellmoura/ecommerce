package com.order.client;


import com.order.configuration.feign.clients.ProductFeignSupportConfiguration;
import com.order.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", url = "http://localhost:8081", configuration = ProductFeignSupportConfiguration.class)
public interface ProductFeignClient {

    @GetMapping("/products/{id}")
    ProductDTO findById(@PathVariable Long id);
}
