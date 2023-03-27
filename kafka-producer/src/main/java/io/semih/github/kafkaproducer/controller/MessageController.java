package com.example.kafkaproducer.controller;

import com.example.kafkaproducer.model.Message;
import com.example.kafkaproducer.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/producer")
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/send")
    public void send(@RequestBody Message message) {
        messageService.produce(message);
    }

}