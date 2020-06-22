package com.nix.zemnitskiy.weatherapp.impl;

import com.nix.zemnitskiy.api.Weather;
import com.nix.zemnitskiy.api.WeatherService;
import com.nix.zemnitskiy.cassandra.repository.WeatherRepository;
import com.nix.zemnitskiy.mail.CamelMailSenderImpl;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.jaxrs.client.WebClient;
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
