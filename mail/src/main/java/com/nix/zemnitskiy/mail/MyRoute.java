package com.nix.zemnitskiy.mail;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {

    @Value("${camel.email}")
    private String email;
    @Value("${camel.smtp}")
    private String smtp;

    @Override
    public void configure() {
        from("direct:sendWeather")
                .setHeader("subject", simple("Test Message"))
                .setHeader("to", simple(email))
                .to(smtp);
    }
}
