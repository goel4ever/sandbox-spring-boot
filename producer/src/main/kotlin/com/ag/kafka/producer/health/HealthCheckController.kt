package com.ag.kafka.producer.health

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController(
) {

    @GetMapping("/health")
    @ResponseBody
    fun healthCheck(): String {
        return "I AM ALIVE!"
    }
}
