package com.nix.zemnitskiy.weatherapp.config;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class WeatherConfig {

    @Bean
    public WebClient getWebClient() {
        List<Object> providers = new ArrayList<>();
        providers.add(new JacksonJaxbJsonProvider());
        return WebClient.create("https://api.openweathermap.org/data/2.5/weather", providers);
    }
}
