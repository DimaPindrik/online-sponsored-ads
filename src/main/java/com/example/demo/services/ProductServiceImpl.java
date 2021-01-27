package com.example.demo.services;

import com.example.demo.entities.dto.ProductDto;
import com.example.demo.repositories.ProductRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ConversionService conversionService;

    public ProductServiceImpl(ProductRepository productRepository, ConversionService conversionService) {
        this.productRepository = productRepository;
        this.conversionService = conversionService;
    }

    @Override
    public ProductDto getProductBySerialNumber(String serialNumber) {
        return null;
    }
}
