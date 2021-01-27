package com.example.demo.services;

import com.example.demo.entities.Campaign;
import com.example.demo.entities.dto.CampaignDto;

public interface CampaignService {

    CampaignDto getCampaignById(Integer id);

    Campaign createCampaign(CampaignDto campaign);
}
