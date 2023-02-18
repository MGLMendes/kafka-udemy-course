package com.miguel.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info("Send message {}", message);
        kafkaTemplate.send("str-topic", message)
                .addCallback(  //addCallback é pra termos infomrações se deu sucesso ou falha ao produzir a mensagem
                success -> {
                    if (success != null) {
                        log.info("Send message with success {}", message);
                        log.info("Partition: {}", success.getRecordMetadata().partition());  // metodo para pegarmos a partição
                        log.info("Offset: {}", success.getRecordMetadata().offset());  // metodo para pegarmos a offset
                    }
                },
                error -> log.error("Error sending message {}", message)
        );

    }

}
