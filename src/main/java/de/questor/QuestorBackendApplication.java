package de.questor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class QuestorBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestorBackendApplication.class, args);
	}
}
