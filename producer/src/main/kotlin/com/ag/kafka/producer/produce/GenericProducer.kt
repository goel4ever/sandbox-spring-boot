package com.ag.kafka.producer.produce

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class GenericProducer(
    @Autowired private var kafkaTemplate: KafkaTemplate<String, String>
) {
    fun send(topic: String, key: String?, message: String) {
        if (key.isNullOrEmpty()) {
            send(topic, message)
        } else {
            kafkaTemplate.send(topic, key, message)
        }
    }

    fun send(topic: String, message: String) {
        kafkaTemplate.send(topic, message)
    }
}