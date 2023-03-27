package io.semih.github.kafkaconsumer.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("batch-object")
public record EventMessage(String message) {}