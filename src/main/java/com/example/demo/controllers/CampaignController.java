package com.example.demo.controllers;

import com.example.demo.entities.dto.CampaignDto;
import com.example.demo.services.CampaignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping
    @RequestMapping("campaign")
    public void createCampaign(@RequestBody CampaignDto campaignDto) {
        
    }
}
