package com.comanda.server.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.comanda.server.services.DBTestService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBTestService dbTestService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		dbTestService.instantiateTestDatabase();
		return true;
	}

}
