package com.nix.zemnitskiy.weatherapp.test;

import com.nix.zemnitskiy.api.Temperature;
import com.nix.zemnitskiy.api.Weather;
import com.nix.zemnitskiy.weatherapp.impl.ProviderWeatherServiceImpl;
import com.nix.zemnitskiy.weatherapp.impl.WeatherServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import javax.ws.rs.BadRequestException;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceImplTest {
    @Mock
    ProviderWeatherServiceImpl providerWeatherServiceImplmock;

    @Test
    public void getWeatherMethodDefaultValueCheck() {
        Weather londonWeather = new Weather(2, "london", "clouds", new Temperature(), 15, 15);
        Mockito.when(providerWeatherServiceImplmock.getWeatherbyCity("london")).thenReturn(londonWeather);
        WeatherServiceImpl weatherServiceImpl = new WeatherServiceImpl(providerWeatherServiceImplmock);
        assertEquals(weatherServiceImpl.getWeather("london"), londonWeather.toString());
    }


    @Test(expected = BadRequestException.class)
    public void getWeatherMethodInvalidValueCheck() {
        Mockito.when(providerWeatherServiceImplmock.getWeatherbyCity("FictionalCity")).thenThrow(new BadRequestException("city not found"));
        new WeatherServiceImpl(providerWeatherServiceImplmock).getWeather("FictionalCity");
    }
}
