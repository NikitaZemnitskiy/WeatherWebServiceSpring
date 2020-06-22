package com.nix.zemnitskiy.weatherapp.impl;

import com.nix.zemnitskiy.api.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final ProviderWeatherServiceImpl providerWeatherService;

    @Override
    public String getWeather(String city) {
        return providerWeatherService.getWeatherbyCity(city).toString();
    }
}
