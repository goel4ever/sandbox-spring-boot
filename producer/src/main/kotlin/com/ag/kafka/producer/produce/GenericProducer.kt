package com.ag.kafka.producer.produce

import mu.KotlinLogging
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Component

@Component
class GenericProducer(
    @Autowired private var kafkaTemplate: KafkaTemplate<String, String>
) {
    private val logger = KotlinLogging.logger {}

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

    fun sendWithProducerRecord(topic: String, message: String) {
        val record: ProducerRecord<String, String> = ProducerRecord(topic, message)
        kafkaTemplate.send(record)
    }

    // TODO
    fun sendWithDeliveryReport(topic: String, message: String) {
        val record: ProducerRecord<String, String> = ProducerRecord(topic, message)
//        kafkaTemplate.send(record, SomeCallback())
    }

    fun sendSync(topic: String, message: String): SendResult<String, String> {
        logger.debug("Sending async mess")
        try {
            return kafkaTemplate.send(topic, message).get()
        } catch (e: Exception) {
            logger.warn("Failed to send message synchronously")
            logger.debug(e.printStackTrace().toString())
            throw e
        }
    }
}
