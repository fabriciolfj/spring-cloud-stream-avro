package com.github.fabriciolfj.consumerv1;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
@Log4j2
public class ConsumerV1Application {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerV1Application.class, args);
	}

	@Bean
	public Consumer<Person> person() {
		return p -> log.info("Person consumer: {}", p.toString());
	}

}
