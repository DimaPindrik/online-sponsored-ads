package com.example.demo.services;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.entities.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto getProductBySerialNumber(String serialNumber);

    List<Product> getAllProductsByCategory(Category category);
}
