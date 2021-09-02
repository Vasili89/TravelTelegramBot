package by.telegrambot.travel.service;

import by.telegrambot.travel.dto.City;
import by.telegrambot.travel.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
