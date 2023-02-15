package com.ag.streaming.file.health

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {
    @GetMapping("/health")
    @ResponseBody
    fun healthCheck(): String {
        return "I AM ALIVE!"
    }
}
