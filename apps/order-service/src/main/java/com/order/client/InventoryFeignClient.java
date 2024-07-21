package com.order.client;


import com.order.dto.InventoryDTO;
import com.order.exceptions.decoders.InventoryServiceErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "inventory-service", url = "http://localhost:8082/inventory", configuration = InventoryServiceErrorDecoder.class)
public interface InventoryFeignClient {

    @GetMapping("/product_id/{id}")
    InventoryDTO findByProductId(@PathVariable Long id);

    @PutMapping("/{id}")
    InventoryDTO update(@PathVariable Long id, @RequestBody InventoryDTO request);
}
