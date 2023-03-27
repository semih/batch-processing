package io.semih.github.kafkareader.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("batch-object")
public record EventMessage(String message) {}