package io.semih.github.kafkaproducer.controller;

import io.semih.github.kafkaproducer.dto.EventMessage;
import io.semih.github.kafkaproducer.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
@Slf4j
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/{skip}/{limit}")
    public void get(@PathVariable String skip, @PathVariable String limit) throws IOException, InterruptedException {
        URI uri = URI.create(String.format("https://onboarding-project5973.p.rapidapi.com/catalog/products?skip=%s&limit=%s", skip, limit));
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("X-RapidAPI-Key", "d5570443c1mshe709386f3696434p114a18jsn409cfbf206ec")
                .header("X-RapidAPI-Host", "onboarding-project5973.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        messageService.produce(new EventMessage(response.body()));
    }

}