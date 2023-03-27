package io.semih.github.kafkaproducer.service;

import io.semih.github.kafkaproducer.dto.EventMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MessageService {

    @Value("${event.kafka.topic.name}")
    private String topicName;

    private final KafkaTemplate<String, EventMessage> kafkaTemplate;

    public void produce(EventMessage eventMessage) {
        kafkaTemplate.send(topicName, eventMessage);
    }

}