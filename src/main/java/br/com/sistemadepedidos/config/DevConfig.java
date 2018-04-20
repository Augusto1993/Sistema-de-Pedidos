/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemadepedidos.config;

import br.com.sistemadepedidos.services.DBService;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author Grazziano Fagundes
 */
@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBService dbService;
    
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instantiateDatabase() throws ParseException {
        if (!"create-drop".equals(strategy)) {
            return false;
        }
        
        dbService.instantiateTestDatabase();
        return true;
    }
}
