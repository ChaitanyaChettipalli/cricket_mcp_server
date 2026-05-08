package com.mcp.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class McpServerApplication {

	public @Bean com.mongodb.client.MongoClient mongoClient() {
		return com.mongodb.client.MongoClients.create(System.getenv("MONGO_URL"));
	}

	public static void main(String[] args) {
		SpringApplication.run(McpServerApplication.class, args);
	}


}
