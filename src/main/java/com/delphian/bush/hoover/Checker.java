package com.delphian.bush.hoover;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class Checker {

    @KafkaListener(topics = {"news"})
//    @KafkaListener(topics = {"stats"})
    public void onMessage(ConsumerRecord<String, String> consumerRecord) throws IOException {
        System.out.println("Received record, value: {" + consumerRecord.value() + "}");
    }}
