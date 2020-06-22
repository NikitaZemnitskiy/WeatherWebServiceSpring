package com.nix.zemnitskiy.mail;

import com.nix.zemnitskiy.api.Weather;
import lombok.RequiredArgsConstructor;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CamelMailSenderImpl implements CamelMailSender {
    private final CamelContext context;

    @Override
    public void sendEmail(Weather weather) {
        ProducerTemplate producerTemplate = context.createProducerTemplate();
        producerTemplate.sendBody("direct:sendWeather", weather.toString());
    }

}
