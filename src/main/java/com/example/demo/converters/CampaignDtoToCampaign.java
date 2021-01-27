package com.example.demo.converters;

import com.example.demo.entities.Campaign;
import com.example.demo.entities.dto.CampaignDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CampaignDtoToCampaign implements Converter<CampaignDto, Campaign> {


    @Override
    public Campaign convert(CampaignDto source) {

        final Campaign campaign = new Campaign();
        campaign.setBid(source.getBid());
        campaign.setStartDate(source.getStartDate());
        campaign.setCategory(source.getCategory());
        campaign.setName(source.getName());
        campaign.setProducts(source.getProducts());

        return campaign;
    }
}
