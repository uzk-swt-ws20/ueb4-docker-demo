package de.unikoeln.dockerdemo;

import de.unikoeln.dockerdemo.entity.UserProfile;
import de.unikoeln.dockerdemo.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class DockerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(UserRepository repository) {

		return args -> {
			log.info("Preloading " + repository.save(
					new UserProfile("Max Mustermann", "max@mustermann.de",
							true, false)));
			log.info("Preloading " + repository.save(
					new UserProfile("Anton Schlömer", "aschloe5@smail.uni-koeln.de",
							true, true)));
		};
	}
}
