package com.rasysbox;

import com.rasysbox.entity.Movie;
import com.rasysbox.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	@Profile("local")
	CommandLineRunner initDatabase(MovieRepository repository) {
		return args -> {
			repository.save(new Movie("El martir del Calvario", "Miguel Morayta", new BigDecimal("15.41")));
			repository.save(new Movie("La pasion de Cristo", "Mel Gibson", new BigDecimal("9.69")));
			repository.save(new Movie("Le Tout Nouveau Testament", "Jaco van Dormael", new BigDecimal("47.99")));
		};
	}

}
