package com.example.demo.services;

import com.example.demo.entities.dto.ProductDto;

public interface ProductService {

    ProductDto getProductBySerialNumber(String serialNumber);
}
