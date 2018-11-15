package com.carolinathomaz.api;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.carolinathomaz.api.domain.Diario;
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
          Diario diario = new Diario(null, "palavra 1", "teste", sdf.parse("15/11/2018"));
           
          diario = diarioService.insert(diario);
          
          System.out.println(diario.toString());
          
          Diario dia = diarioService.findById("palavra 1");
          
          System.out.println(dia.getPalavra());
	}
}
