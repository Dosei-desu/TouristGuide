package com.example.turistguide.controllers;

import com.example.turistguide.models.TouristAttraction;
import com.example.turistguide.services.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {
    TouristService touristService = new TouristService();

    @GetMapping("attractions/all")
    public ResponseEntity<List<TouristAttraction>> getAllAttractions(){
        List<TouristAttraction> attractionList = touristService.getAttractions();
        return new ResponseEntity<>(attractionList, HttpStatus.OK);
    }

    @GetMapping("attractions/{name}")
    public ResponseEntity<TouristAttraction> getAttraction(@PathVariable String name){
        TouristAttraction touristAttraction = touristService.getAttractionWithName(name);
        if (touristAttraction == null){
            return new ResponseEntity<>(new TouristAttraction(
                    "Does","Not Exist"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    @PostMapping("attractions/create")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction attraction){
        TouristAttraction touristAttraction = touristService.addAttraction(attraction);
        if (touristAttraction == null){
            return new ResponseEntity<>(new TouristAttraction(
                    "Attraction","Already Exists"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    @PutMapping("attractions/update")
    public ResponseEntity<TouristAttraction> changeAttraction(@RequestBody TouristAttraction attraction){
        TouristAttraction touristAttraction = touristService.changeAttraction(attraction);
        if (touristAttraction == null){
            return new ResponseEntity<>(new TouristAttraction(
                    "Does","Not Exist"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    @DeleteMapping("attractions/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String name){
        TouristAttraction touristAttraction = touristService.deleteAttraction(name);
        if (touristAttraction == null){
            return new ResponseEntity<>(new TouristAttraction(
                    "Does","Not Exist"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }
}
