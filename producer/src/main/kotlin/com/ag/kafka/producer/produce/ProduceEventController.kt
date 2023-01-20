package com.ag.kafka.producer.produce

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProduceEventController {

    @GetMapping("/send")
    @ResponseBody
    fun sendEvent(): String {
        return "Event sent!"
    }

    @GetMapping("/send/batch")
    @ResponseBody
    fun sendBatchEvents(): String {
        return "Batch of 10 events sent!"
    }
}
