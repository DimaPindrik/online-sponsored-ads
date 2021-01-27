package com.example.demo.controllers;

import com.example.demo.entities.Campaign;
import com.example.demo.entities.dto.CampaignDto;
import com.example.demo.services.CampaignService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping
    @RequestMapping("/create-campaign")
    public Campaign createCampaign(@RequestBody CampaignDto campaignDto) {
        return campaignService.createCampaign(campaignDto);
    }
}
