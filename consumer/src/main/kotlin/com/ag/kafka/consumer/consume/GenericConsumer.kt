package com.ag.kafka.consumer.consume

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component


@Component
class GenericConsumer {
    companion object {
        const val TEST_TOPIC = "test-topic"
        const val TEST_TOPIC_BATCH = "test-topic-batch"
    }

    @KafkaListener(
        topics = [TEST_TOPIC],
        groupId = "api",
        properties = [
            "listener.type=batch",
            "auto-offset-reset=earliest",
            "max-poll-records=5",
        ],
    )
    fun listen(kafkaMessage: ConsumerRecord<String?, String?>) {
//        val messageValue = kafkaMessage.value()?.let { String(it) }
        println("Consuming single message")
        println(kafkaMessage.value())
    }

    @KafkaListener(
        topics = [TEST_TOPIC_BATCH],
        groupId = "api",
        properties = [
            "spring.kafka.listener.type=batch",
            "auto-offset-reset=earliest",
            "max-poll-records=5",
        ],
    )
//    fun listenBatch(kafkaMessages: List<ConsumerRecord<String?, String?>>) {
    fun listenBatch(kafkaMessages: List<String>) {
//        val messageValue = kafkaMessage.value()?.let { String(it) }
        println("Consuming batch messages with size ${kafkaMessages.size}")
        for (kafkaMessage in kafkaMessages) {
            println(kafkaMessage)
//            println(kafkaMessage.value())
        }
    }
}
