package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "campaigns")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;

    private Category category;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    private double bid;
}
