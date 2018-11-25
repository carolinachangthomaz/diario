package com.carolinathomaz.api;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.carolinathomaz.api.service.DiarioService;

@SpringBootApplication
public class ApiPalavrasApplication implements CommandLineRunner{
	
	@Autowired
	private DiarioService diarioService;


	public static void main(String[] args) {
		SpringApplication.run(ApiPalavrasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	      
	}
	
}
