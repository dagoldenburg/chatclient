package com.rofl.chatclient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.net.URI;

class Client {

    WebClient client;

     Client(WebClient webClient) {
        this.client = webClient;
    }

    void postMessage() {
        ChatMessage chatMessage = new ChatMessage("hej hej", "12:34", "Daggen");

        client.post()
                .uri(URI.create("/postMessage"))
                .body(BodyInserters.fromObject(chatMessage))
        .retrieve();
    }

    void listenForMessages() {
        Flux<ChatMessage> chatMessageMono = client.get()
                .uri("/}")
                .retrieve()
                .bodyToFlux(ChatMessage.class);

        chatMessageMono.subscribe(System.out::println);
    }

}
