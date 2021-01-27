package com.example.demo.config;

import com.example.demo.converters.CampaignDtoToCampaign;
import com.example.demo.converters.ProductDtoToProduct;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new CampaignDtoToCampaign());
        registry.addConverter(new ProductDtoToProduct());
    }
}
