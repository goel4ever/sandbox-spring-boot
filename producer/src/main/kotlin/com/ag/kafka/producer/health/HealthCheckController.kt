package com.ag.kafka.producer.health

import com.ag.kafka.producer.produce.GenericProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController(
    @Autowired private var kafkaProducer: GenericProducer,
) {
    companion object {
        const val TEST_TOPIC = "test-topic"
    }

    @GetMapping("/health")
    @ResponseBody
    fun healthCheck(): String {
        return "I AM ALIVE!"
    }

    @GetMapping("/kafka/connection")
    @ResponseBody
    fun kafkaConnectionCheck(): String {
        kafkaProducer.send(TEST_TOPIC, "test message sent here")
        return "Message sent to topic successfully"
    }
}
