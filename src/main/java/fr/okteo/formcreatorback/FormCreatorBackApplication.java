package fr.okteo.formcreatorback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"fr.okteo.formcreatorback"})
public class FormCreatorBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormCreatorBackApplication.class, args);
	}

}
