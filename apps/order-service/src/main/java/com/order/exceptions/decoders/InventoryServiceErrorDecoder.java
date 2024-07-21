package com.order.exceptions.decoders;

import com.order.exceptions.BadRequestException;
import com.order.exceptions.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class InventoryServiceErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                return new BadRequestException("Bad Request");
            case 404:
                return new NotFoundException("Inventory not found by product");
            default:
                return errorDecoder.decode(methodKey, response);
        }
    }
}