package com.myco.central.commons.dao.springjpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.myco.central.commons.model.Country;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(CountryRepository repository) {
		return (args) -> {
			repository.save(new Country("Argentina", "AR"));
			repository.save(new Country("Brasil", "BR"));
			repository.save(new Country("Chile", "CL"));
			repository.save(new Country("Colombia", "CO"));
			repository.save(new Country("Venezuela", "VZ"));

			// fetch all countries
			log.info("Countries found with findAll():");
			log.info("-------------------------------");
			for (Country country : repository.findAll()) {
				log.info(country.toString());
			}
            log.info("");

			// fetch an individual country by ID
			Country country = repository.findOne(1L);
			log.info("Country found with findOne(1L):");
			log.info("--------------------------------");
			log.info(country.toString());
            log.info("");

			// fetch countries by name
			log.info("Country found with findByLastName('Argentina'):");
			log.info("--------------------------------------------");
			for (Country argentina : repository.findByName("Argentina")) {
				log.info(argentina.toString());
			}
            log.info("");
		};
	}

}