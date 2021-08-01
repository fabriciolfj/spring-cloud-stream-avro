package com.github.fabriciolfj.producer.controller;

import com.github.fabriciolfj.producer.model.PersonAvro;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/persons")
public class PersonController {

    private final StreamBridge streamBridge;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void send(@RequestBody final PersonAvro personAvro) {
        personAvro.setCode(UUID.randomUUID().toString());
        personAvro.setName(personAvro.getName());

        streamBridge.send("person-out-0", personAvro);
    }
}