package com.rofl.chatclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ChatclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatclientApplication.class, args);

	}

	@Bean
	public WebClient webClient() {
		return WebClient.create("http://localhost:8080/");
	}

	@Bean
	public Client client(WebClient webClient) {
		Client client = new Client(webClient);
		client.listenForMessages();
		return client;
	}

}
