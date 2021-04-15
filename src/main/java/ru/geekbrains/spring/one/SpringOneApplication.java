package ru.geekbrains.spring.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringOneApplication {
	// Домашнее задание
	// 1. На главной странице сделать форму для поиска студента по Id
	// вбили id - перешли на страницу показа соответствующего студента (страница есть)
	// 2. Добавьте на странице со списком студентов по бокам балла две кнопки "-" и "+",
	// при нажатии на которые доолжен происходить декремент и инкремент балла студента.
	// Балл не может быть меньше 0 и больше 100

	public static void main(String[] args) {
		SpringApplication.run(SpringOneApplication.class, args);
	}
}
