package com.example.turistguide.services;

import com.example.turistguide.models.TouristAttraction;
import com.example.turistguide.repositories.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository){
        this.touristRepository = touristRepository;
    }

    public List<TouristAttraction> getAttractions() {
        return touristRepository.getAttractions();
    }

    public TouristAttraction getAttractionWithName(String name){
        return touristRepository.getAttractionsWithName(name);
    }

    public TouristAttraction addAttraction(TouristAttraction attraction){
        return touristRepository.addAttraction(attraction);
    }

    public TouristAttraction changeAttraction(TouristAttraction attraction){
        return touristRepository.changeAttraction(attraction);
    }

    public TouristAttraction deleteAttraction(String name){
        return touristRepository.deleteAttraction(name);
    }
}
