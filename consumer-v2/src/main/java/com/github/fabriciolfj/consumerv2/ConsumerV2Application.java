package com.github.fabriciolfj.consumerv2;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
@Log4j2
public class ConsumerV2Application {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerV2Application.class, args);
	}

	@Bean
	public Consumer<Person> person() {
		return p -> log.info("Message consumer: {}", p.toString());
	}

}
