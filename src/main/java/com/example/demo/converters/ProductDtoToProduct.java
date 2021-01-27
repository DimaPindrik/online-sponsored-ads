package com.example.demo.converters;

import com.example.demo.entities.Product;
import com.example.demo.entities.dto.ProductDto;
import org.springframework.core.convert.converter.Converter;

public class ProductDtoToProduct implements Converter<ProductDto, Product> {

    @Override
    public Product convert(ProductDto source) {

        final Product product = new Product();

        product.setTitle(source.getTitle());
        product.setPrice(source.getPrice());
        product.setCategory(source.getCategory());
        product.setSerialNumber(source.getSerialNumber());

        return product;
    }
}
