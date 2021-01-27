package com.example.demo.services;

import com.example.demo.entities.Campaign;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.entities.dto.CampaignDto;
import com.example.demo.repositories.CampaignRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampaignServiceImpl implements CampaignService {

    private static final long ACTIVE_PERIOD_DAYS = 10;

    private final CampaignRepository campaignRepository;
    private final ProductService productService;
    private final ConversionService conversionService;

    public CampaignServiceImpl(CampaignRepository campaignRepository, ProductService productService, ConversionService conversionService) {
        this.campaignRepository = campaignRepository;
        this.productService = productService;
        this.conversionService = conversionService;
    }

    @Override
    public Campaign createCampaign(CampaignDto campaignDto) {
        List<Product> products = productService.getAllProductsByCategory(campaignDto.getCategory());
        Campaign campaign = conversionService.convert(campaignDto, Campaign.class);
        return campaignRepository.save(campaign);
    }

    @Override
    public Product retrieveAd(Category category) {
        List<Campaign> campaigns = campaignRepository.findByCategory(category);
        List<Campaign> activeCampaigns = campaigns.stream()
                .filter(this::isActive)
                .collect(Collectors.toList());
        return getHighestBidProductInCampaigns(activeCampaigns);
    }

    private boolean isActive(Campaign campaign) {
        LocalDate startDate = campaign.getStartDate();
        return LocalDate.now().isAfter(startDate) && LocalDate.now().isBefore(startDate.plusDays(ACTIVE_PERIOD_DAYS));
    }

    private Product getHighestBidProductInCampaigns(List<Campaign> activeCampaigns) {
        Product product = null;
        double highestBid = .0;
        for (Campaign campaign : activeCampaigns) {
            if (campaign.getBid() > highestBid) {
                highestBid = campaign.getBid();
                // get the first product of the campaign
                product = campaign.getProducts().get(0);
            }
        }
        return product;
    }
}
