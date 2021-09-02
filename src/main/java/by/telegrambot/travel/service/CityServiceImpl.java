package by.telegrambot.travel.service;

import by.telegrambot.travel.dto.City;
import by.telegrambot.travel.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements ICityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City findCity(String cityName) {
        return cityRepository.findByNameIgnoreCase(cityName).orElse(null);
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCity(City city) {
        cityRepository.save(city);
    }

    @Override
    public void deleteCity(City city) {;
        cityRepository.delete(city);
    }

}
