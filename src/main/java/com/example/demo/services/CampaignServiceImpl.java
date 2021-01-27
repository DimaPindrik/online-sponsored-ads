package com.example.demo.services;

import com.example.demo.entities.Campaign;
import com.example.demo.entities.Product;
import com.example.demo.entities.dto.CampaignDto;
import com.example.demo.repositories.CampaignRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;
    private final ProductService productService;
    private final ConversionService conversionService;

    public CampaignServiceImpl(CampaignRepository campaignRepository, ProductService productService, ConversionService conversionService) {
        this.campaignRepository = campaignRepository;
        this.productService = productService;
        this.conversionService = conversionService;
    }

    @Override
    public CampaignDto getCampaignById(Integer id) {
        return null;
    }

    @Override
    public Campaign createCampaign(CampaignDto campaignDto) {
        List<Product> products = productService.getAllProductsByCategory(campaignDto.getCategory());
        Campaign campaign = conversionService.convert(campaignDto, Campaign.class);
        campaign.setProducts(products);
        return campaignRepository.save(campaign);
    }
}
