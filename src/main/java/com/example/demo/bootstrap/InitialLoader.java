package com.example.demo.bootstrap;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class InitialLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final ProductRepository productRepository;

    public InitialLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }

    private void init() {

        // init products
        List<Product> products = new ArrayList<>();

        Product product1 = new Product();
        product1.setSerialNumber(UUID.randomUUID().toString());
        product1.setCategory(Category.CLOTHES);
        product1.setPrice(100.0);
        product1.setTitle("Nike Shirt");
        products.add(product1);

        Product product2 = new Product();
        product2.setSerialNumber(UUID.randomUUID().toString());
        product2.setCategory(Category.SHOES);
        product2.setPrice(200.0);
        product2.setTitle("Nike Shoes");
        products.add(product2);

        Product product3 = new Product();
        product3.setSerialNumber(UUID.randomUUID().toString());
        product3.setCategory(Category.SMARTPHONE);
        product3.setPrice(1000.0);
        product3.setTitle("IPhoneX");
        products.add(product3);

        Product product4 = new Product();
        product4.setSerialNumber(UUID.randomUUID().toString());
        product4.setCategory(Category.SMARTPHONE);
        product4.setPrice(500);
        product4.setTitle("Xiaomi");
        products.add(product4);

        productRepository.saveAll(products);
    }
}
