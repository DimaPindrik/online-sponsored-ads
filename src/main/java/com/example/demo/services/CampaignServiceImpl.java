package com.example.demo.services;

import com.example.demo.entities.dto.CampaignDto;
import com.example.demo.repositories.CampaignRepository;
import org.springframework.stereotype.Service;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;

    public CampaignServiceImpl(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }


    @Override
    public CampaignDto getCampaignById(Integer id) {
        return null;
    }
}
