package com.example.demo.services;

import com.example.demo.entities.dto.CampaignDto;
import com.example.demo.repositories.CampaignRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;
    private final ConversionService conversionService;

    public CampaignServiceImpl(CampaignRepository campaignRepository, ConversionService conversionService) {
        this.campaignRepository = campaignRepository;
        this.conversionService = conversionService;
    }


    @Override
    public CampaignDto getCampaignById(Integer id) {
        return null;
    }
}
