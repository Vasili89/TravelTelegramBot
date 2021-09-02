package by.telegrambot.travel.controller;

import by.telegrambot.travel.dto.City;
import by.telegrambot.travel.service.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityServiceImpl cityService;

    @Autowired
    public CityController(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCities() {
        List<City> cities = cityService.getAllCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCity(@PathVariable Long id) {
        City city = cityService.getCityById(id);
        if (city == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addNewCity(@RequestBody City newCity) {
        newCity.setId(null);
        if (cityService.findCity(newCity.getName()) != null) {
            return new ResponseEntity<>("City is exists! " +
                    cityService.findCity(newCity.getName()).toString(), HttpStatus.BAD_REQUEST);
        }
        if (newCity.getName() == null || newCity.getMessage() == null ||
            newCity.getName().isBlank() || newCity.getMessage().isBlank()) {
            return new ResponseEntity<>("Please, insert a correct data!", HttpStatus.BAD_REQUEST);
        }
        cityService.saveCity(newCity);
        return new ResponseEntity<>(newCity, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editCity(@PathVariable Long id, @RequestBody City editedCity) {
        if (cityService.getCityById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        City cityForEdit = cityService.getCityById(id);
        if (editedCity.getName() != null && !editedCity.getName().isBlank()) {
            cityForEdit.setName(editedCity.getName());
        }
        if (editedCity.getMessage() != null && !editedCity.getMessage().isBlank()) {
            cityForEdit.setMessage(editedCity.getMessage());
        }
        cityService.saveCity(cityForEdit);
        return new ResponseEntity<>(cityForEdit, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable Long id) {
        City city = cityService.getCityById(id);
        if (city == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        cityService.deleteCity(city);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
