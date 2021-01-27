package com.example.demo.entities.dto;

import com.example.demo.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String serialNumber;
    private String title;
    private Category category;
    private double price;
}
