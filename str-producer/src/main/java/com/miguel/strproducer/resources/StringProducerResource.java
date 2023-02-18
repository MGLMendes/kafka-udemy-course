package com.miguel.strproducer.resources;

import com.miguel.strproducer.services.StringProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/producer")
@RequiredArgsConstructor
public class StringProducerResource {

    private final StringProducerService service;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody String message) {
        service.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
