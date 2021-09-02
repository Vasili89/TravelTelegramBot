package by.telegrambot.travel.service;

import by.telegrambot.travel.dto.City;

import java.util.List;

public interface ICityService {

    City findCity(String cityName);

    List<City> getAllCities();

    City getCityById(Long id);

    void saveCity(City city);

    void deleteCity(City city);

}
