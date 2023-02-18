package com.miguel.strconsumer.listeners;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StrConsumerListener {

    @KafkaListener(groupId = "group-1",  //definição do groupId
            topicPartitions = {
                @TopicPartition(topic = "str-topic", partitions = {"0"})  //Desse jeito definimos qual partição esse groupId irá monitorar
            },
            containerFactory = "strContainerFactory")  // definição do container
    public void create(String message) {
        log.info("CREATE ::: Received message {}", message);
    }

    @KafkaListener(groupId = "group-1",
            topicPartitions = {
                @TopicPartition(topic = "str-topic", partitions = {"1"})
            },
            containerFactory = "strContainerFactory")
    public void log(String message) {
        log.info("LOG ::: Receive message {}", message);
    }


    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "strContainerFactory")
    public void history(String message) {
        log.info("HISTORY ::: Receive message {}", message);
    }
}
