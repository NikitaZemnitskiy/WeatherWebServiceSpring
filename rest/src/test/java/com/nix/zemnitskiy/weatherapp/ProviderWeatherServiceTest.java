package com.nix.zemnitskiy.weatherapp;

import com.nix.zemnitskiy.api.Temperature;
import com.nix.zemnitskiy.api.Weather;
import com.nix.zemnitskiy.cassandra.repository.WeatherRepository;
import com.nix.zemnitskiy.mail.CamelMailSenderImpl;
import com.nix.zemnitskiy.weatherapp.api.ProviderWeatherService;
import com.nix.zemnitskiy.weatherapp.impl.ProviderWeatherServiceImpl;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;


@RunWith(MockitoJUnitRunner.class)
public class ProviderWeatherServiceTest {
    @Mock
    WebClient mockWebClient;

    @Mock
    WeatherRepository mockWeatherRepository;

    @Mock
    CamelMailSenderImpl mockCamelMailSender;

    @Test
    public void getWeatherByCityCorrectInput() {
        Weather londonWeather = new Weather(6223, "london", "clouds", new Temperature(), 15, 15);
        Mockito.when(mockWebClient.reset()).thenReturn(mockWebClient);
        Mockito.when(mockWebClient.query(anyString(), anyString())).thenReturn(mockWebClient);
        Mockito.when(mockWebClient.get(Weather.class)).thenReturn(londonWeather);
        ProviderWeatherService providerWeatherService = new ProviderWeatherServiceImpl(mockWebClient, mockWeatherRepository, mockCamelMailSender);
        assertEquals(providerWeatherService.getWeatherbyCity("london"), londonWeather);
    }
}
