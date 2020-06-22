package com.nix.zemnitskiy.weatherapp.impl;

import com.nix.zemnitskiy.api.Weather;
import com.nix.zemnitskiy.cassandra.repository.WeatherRepository;
import com.nix.zemnitskiy.mail.CamelMailSenderImpl;
import com.nix.zemnitskiy.weatherapp.ProviderWeatherService;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProviderWeatherServiceImpl implements ProviderWeatherService {

    private static final String WEATHER_KEY = "9bc9127b5ca9be05751bd273761634d4";
    private final static String UNITS = "metric";
    private final WebClient webClient;
    private final WeatherRepository weatherRepository;
    private final CamelMailSenderImpl camelMailSender;

    public Weather getWeatherbyCity(String city){
        Weather weather = webClient.reset()
                .query("q", city)
                .query("units", UNITS)
                .query("APPID", WEATHER_KEY)
                .get(Weather.class);
        weatherRepository.save(weather);
        camelMailSender.sendEmail(weather);
        return weather;
    }
}
