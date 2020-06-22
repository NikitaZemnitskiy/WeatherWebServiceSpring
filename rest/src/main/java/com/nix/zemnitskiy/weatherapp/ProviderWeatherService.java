package com.nix.zemnitskiy.weatherapp;

import com.nix.zemnitskiy.api.Weather;

public interface ProviderWeatherService {
    public Weather getWeatherbyCity(String city);
}
