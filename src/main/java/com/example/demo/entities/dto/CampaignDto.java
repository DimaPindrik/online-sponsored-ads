package com.example.demo.entities.dto;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CampaignDto {

    private int id;
    private String name;
    private LocalDate startDate;
    private Category category;
    private List<Product> products = new ArrayList<>();
    private double bid;

}
