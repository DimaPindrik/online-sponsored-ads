package com.example.demo.bootstrap;

import com.example.demo.entities.Campaign;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repositories.CampaignRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class InitialLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final CampaignRepository campaignRepository;

    public InitialLoader(ProductRepository productRepository, CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }

    private void init() {

        // init products
        Product product1 = new Product();
        product1.setSerialNumber(UUID.randomUUID().toString());
        product1.setCategory(Category.CLOTHES);
        product1.setPrice(100.0);
        product1.setTitle("Nike Shirt");


        Product product2 = new Product();
        product2.setSerialNumber(UUID.randomUUID().toString());
        product2.setCategory(Category.SHOES);
        product2.setPrice(200.0);
        product2.setTitle("Nike Shoes");

        Product product3 = new Product();
        product3.setSerialNumber(UUID.randomUUID().toString());
        product3.setCategory(Category.SMARTPHONE);
        product3.setPrice(1000.0);
        product3.setTitle("IPhoneX");

        Product product4 = new Product();
        product4.setSerialNumber(UUID.randomUUID().toString());
        product4.setCategory(Category.SMARTPHONE);
        product4.setPrice(500);
        product4.setTitle("Xiaomi");

        // init campaigns
        List<Campaign> campaigns = new ArrayList<>();

        Campaign campaign1 = new Campaign();
        campaign1.setId(1);
        campaign1.setName("First Campaign");
        campaign1.setCategory(Category.CLOTHES);
        campaign1.setStartDate(LocalDate.now());
        campaign1.setBid(20.0);
        campaign1.getProducts().add(product1);
        campaigns.add(campaign1);

        Campaign campaign2 = new Campaign();
        campaign2.setId(2);
        campaign2.setName("Second Campaign");
        campaign2.setCategory(Category.SHOES);
        campaign2.setStartDate(LocalDate.now());
        campaign2.setBid(30.0);
        campaign2.getProducts().add(product2);
        campaigns.add(campaign2);

        Campaign campaign3 = new Campaign();
        campaign3.setId(3);
        campaign3.setName("Last Campaign");
        campaign3.setCategory(Category.SMARTPHONE);
        campaign3.setStartDate(LocalDate.now());
        campaign3.setBid(72.0);
        campaign3.getProducts().add(product3);
        campaign3.getProducts().add(product4);
        campaigns.add(campaign3);

        // save all campaigns and products
        campaignRepository.saveAll(campaigns);
    }
}
