package com.nix.zemnitskiy.mail;

import com.nix.zemnitskiy.api.Weather;

public interface CamelMailSender {
    public void sendEmail(Weather weather);
}
