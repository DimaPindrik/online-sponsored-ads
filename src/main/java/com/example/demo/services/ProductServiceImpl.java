package com.example.demo.services;

import com.example.demo.entities.dto.ProductDto;
import com.example.demo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto getProductBySerialNumber(String serialNumber) {
        return null;
    }
}
