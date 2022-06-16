package com.imed.imobiliaria.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(ImobiliariaRepository repository) {

		return args -> {
			log.info("Preloading " + repository.save(new Casa("Venda", 180000.00, "Rua Comandante Kraemer, 15, Passo Fundo/RS", 30.0, "1", "6")));
			log.info("Preloading " + repository.save(new Casa("Aluguel", 1000.00, "Av. Presidente Vargas, 101, Passo Fundo/RS", 25.2, "2", "5")));
			log.info("Preloading " + repository.save(new Casa("Venda", 200000.00, "Rua São Paulo, 54, Erechim/RS", 80.0, "1", "7")));
			log.info("Preloading " + repository.save(new Casa("Aluguel", 1200.00, "Rua Pinheiro Machado, 159, Casca/RS", 65.5, "1", "6")));
		};
	}
}
