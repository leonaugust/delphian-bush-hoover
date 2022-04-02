package com.delphian.bush.hoover.service.hoover;

import com.delphian.bush.hoover.dto.DataType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;
import java.util.Map;

@Slf4j
public abstract class BasicHooverService<T> {

    protected String USD = "USD";
    protected boolean INVERT = true;

    private KafkaTemplate<String, String> kafkaTemplate;

    private ObjectMapper objectMapper;

    @Value("#{${predictor.kafka-topic-by-type}}")
    private Map<DataType, String> topicByType;

    @Value("${spring.profiles.active}")
    private List<String> activeProfiles;

//    TODO: save result to MongoDb instead. Use Kafka Connect
    protected void sendToKafkaAndPrint(T t, String key, DataType type) {
        String topic = topicByType.get(type);
        try {
            kafkaTemplate.send(topic, key, objectMapper.writeValueAsString(t));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        log.debug(t.toString());
    }

    abstract void lookupStats();

    @Autowired(required = false)
    public final void setKafkaTemplate(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Autowired(required = false)
    public final void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    protected boolean isKafkaProfileEnabled() {
        return activeProfiles.contains("kafka");
    }

}
