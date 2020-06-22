package com.nix.zemnitskiy.mail;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {
    @Value("${camel.email}")
    private  String EMAIL;
    @Value("${camel.smtp}")
    private String SMTP;
    @Value("${camel.title}")
    private String TITLE;

    /*MyRoute(@Value("${camel.email}") String email,
            @Value("${camel.smtp}") String smtp,
            @Value("${camel.title}") String title) {
        this.EMAIL = email;
        this.SMTP = smtp;
        this.TITLE = title;
    }*/

    @Override
    public void configure() {
        from("direct:sendWeather")
                .setHeader("subject", simple(TITLE))
                .setHeader("to", simple(EMAIL))
                .to(SMTP);
    }
}
