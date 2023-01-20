package com.ag.kafka.consumer.consume

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class GenericConsumer {
    companion object {
        const val TEST_TOPIC = "test-topic"
    }

    @KafkaListener(
        topics = [TEST_TOPIC],
        groupId = "api"
    )
    fun listen(kafkaMessage: ConsumerRecord<String?, String?>) {
//        val messageValue = kafkaMessage.value()?.let { String(it) }
        println(kafkaMessage.value())
    }
}