package com.example.demo.entities.dto;

import com.example.demo.entities.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RetrieveAdDto {

    private Category category;
}
