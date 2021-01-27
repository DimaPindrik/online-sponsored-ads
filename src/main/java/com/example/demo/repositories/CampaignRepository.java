package com.example.demo.repositories;

import com.example.demo.entities.Campaign;
import com.example.demo.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

    List<Campaign> findByCategory(Category category);
}
