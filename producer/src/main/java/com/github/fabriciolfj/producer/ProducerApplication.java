package com.github.fabriciolfj.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.schema.registry.client.ConfluentSchemaRegistryClient;
import org.springframework.cloud.schema.registry.client.EnableSchemaRegistryClient;
import org.springframework.cloud.schema.registry.client.SchemaRegistryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@EnableSchemaRegistryClient
public class ProducerApplication {

	@Value("${spring.cloud.schema-registry-client.endpoint}")
	private String endpoint;

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Bean
	@Primary
	public SchemaRegistryClient schemaRegistryClient() {
		var client = new ConfluentSchemaRegistryClient();
		client.setEndpoint(endpoint);
		return client;
	}
}
