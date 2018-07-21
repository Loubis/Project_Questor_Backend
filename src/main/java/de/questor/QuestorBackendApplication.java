package de.questor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import de.questor.services.TestService;

@SpringBootApplication
@ComponentScan
public class QuestorBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestorBackendApplication.class, args);
	}
}
