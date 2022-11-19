package com.shubhajit.springbootsoapcountryclient;

import com.shubhajit.springbootsoapcountryclient.country.GetCountryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class SpringBootSoapCountryClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSoapCountryClientApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(CountryClient countryClient) {
        return args -> {
            String country = "Spain";

            if (args.length > 0) {
                country = args[0];
            }
            GetCountryResponse response = countryClient.getCountry(country);
            log.info("Name: {}", response.getCountry().getName());
            log.info("Capital: {}", response.getCountry().getCapital());
            log.info("Population: {}", response.getCountry().getPopulation());
            log.info("Currency: {}", response.getCountry().getCurrency());
        };
    }

}
