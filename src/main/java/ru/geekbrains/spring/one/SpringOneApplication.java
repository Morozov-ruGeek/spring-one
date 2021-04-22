package ru.geekbrains.spring.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import ru.geekbrains.spring.one.repositories.StudentRepository;

@SpringBootApplication
public class SpringOneApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringOneApplication.class, args);
	}
}
