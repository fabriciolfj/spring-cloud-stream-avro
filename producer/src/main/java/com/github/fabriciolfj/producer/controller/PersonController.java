package com.github.fabriciolfj.producer.controller;

import com.github.fabriciolfj.producer.model.PersonDTO;
import com.github.fabriciolfj.producer.schema.PersonAvro;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/persons")
public class PersonController {

    private final StreamBridge streamBridge;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void send(@RequestBody final PersonDTO personDTO) {
        PersonAvro avro = new PersonAvro();
        avro.setCode(UUID.randomUUID().toString());
        avro.setNome(personDTO.getName());

        streamBridge.send("person-out-0", avro);
    }
}