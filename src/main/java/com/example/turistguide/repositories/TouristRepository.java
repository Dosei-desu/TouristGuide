package com.example.turistguide.repositories;

import com.example.turistguide.models.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private List<TouristAttraction> attractions;

    public TouristRepository() {
        attractions = new ArrayList<>(List.of(
                new TouristAttraction("Zoo","Has animals"),
                new TouristAttraction("Circus","Has clowns"),
                new TouristAttraction("Church","Has priests"),
                new TouristAttraction("Pool","Has chlorinated water")
        ));
    }

    public List<TouristAttraction> getAttractions() {
        return attractions;
    }

    public TouristAttraction getAttractionsWithName(String name){
        for (TouristAttraction att: attractions) {
            if (att.getName().equalsIgnoreCase(name)){
                return att;
            }
        }
        return null;
    }

    public TouristAttraction addAttraction(TouristAttraction attraction){
        for (TouristAttraction att: attractions) {
            if (att.getName().equalsIgnoreCase(attraction.getName())){
                return null;
            }
        }
        attractions.add(attraction);
        return attraction;
    }

    public TouristAttraction changeAttraction(TouristAttraction attraction){
        for (int i = 0; i < attractions.size(); i++) {
            if (attractions.get(i).getName().equalsIgnoreCase(attraction.getName())){
                attractions.set(i,attraction);
                return attraction;
            }
        }
        return null;
    }

    public TouristAttraction deleteAttraction(String name){
        TouristAttraction returnAttraction = null;
        for (TouristAttraction att: attractions) {
            if (att.getName().equalsIgnoreCase(name)){
                returnAttraction = att;
            }
        }
        if (returnAttraction != null){
            attractions.remove(returnAttraction);
        }
        return returnAttraction;
    }
}
