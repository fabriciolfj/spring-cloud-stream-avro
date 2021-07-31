package com.github.fabriciolfj.consumerv2;

import com.github.fabriciolfj.producer.model.PersonAvro;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.schema.registry.client.ConfluentSchemaRegistryClient;
import org.springframework.cloud.schema.registry.client.SchemaRegistryClient;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
@Log4j2
public class ConsumerV2Application {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerV2Application.class, args);
	}

	@Bean
	public Consumer<PersonAvro> person() {
		return p -> log.info("Message consumer: {}", p.toString());
	}

	@Bean
	public SchemaRegistryClient schemaRegistryClient(@Value("${spring.cloud.schemaRegistryClient.endpoint}") final String endpoint) {
		var client = new ConfluentSchemaRegistryClient();
		client.setEndpoint(endpoint);
		return client;
	}

}
