package com.napier.sem.semcoursework.controller;


import com.napier.sem.semcoursework.model.City;
import com.napier.sem.semcoursework.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

/**
 * Controller for handling requests related to cities.
 */

@RestController
@RequestMapping("/cities")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CityController {

    private final CityRepository cityRepository;

    /**
     * Endpoint method for retrieving a list of cities in order from largest to smallest.
     *
     * @return ResponseEntity with a list of City objects and an HTTP status of OK (200).
     */

    @GetMapping(value = "/report/1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> cityReport1() {
        try {
            return new ResponseEntity<>(cityRepository.largestToSmallestCitiesWorld(), HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }




    }
    @GetMapping(value = "/report/2/{continent}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> cityReport2(@PathVariable String continent) {

        return new ResponseEntity<>(cityRepository.largestToSmallestCitiesContinent(continent), HttpStatus.OK);

    }

    @GetMapping(value = "/report/3/{region}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> cityReport3(@PathVariable String region) {

        return new ResponseEntity<>(cityRepository.largestToSmallestCitiesRegion(region), HttpStatus.OK);

    }

    @GetMapping(value = "/report/4/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> cityReport4(@PathVariable String country) {

        return new ResponseEntity<>(cityRepository.largestToSmallestCitiesCountry(country), HttpStatus.OK);

    }

    @GetMapping(value = "/report/5/{district}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> cityReport5(@PathVariable String district) {

        return new ResponseEntity<>(cityRepository.largestToSmallestCitiesDistrict(district), HttpStatus.OK);

    }

}
