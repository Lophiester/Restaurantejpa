package com.lophiester.Restaurante.config;

import com.lophiester.Restaurante.services.DBService;
import com.lophiester.Restaurante.services.EmailService;
import com.lophiester.Restaurante.services.MockEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private DBService dbService;

    @Bean
    public boolean instatiateDataBase() throws ParseException {

        dbService.instatiateTestDataBase();
        return true;
    }

    @Bean
    public EmailService emailService() {
        return new MockEmailService();
    }
}
