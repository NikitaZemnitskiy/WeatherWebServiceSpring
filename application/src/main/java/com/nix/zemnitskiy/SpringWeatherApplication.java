package com.nix.zemnitskiy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories(basePackages = {"com.nix.zemnitskiy.cassandra"})
public class SpringWeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWeatherApplication.class, args);
    }

}