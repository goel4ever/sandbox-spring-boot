package com.ag.kafka.producer.produce

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.util.stream.IntStream

@RestController
class ProduceEventController {
    @Autowired private lateinit var producer: GenericProducer

    @GetMapping(path = ["/send"])
    @ResponseBody
    fun sendEvent(): String {
        producer.send("test-topic", "message sent")
        return "Event sent!"
    }

    @GetMapping(path = ["/send/batch"])
    @ResponseBody
    fun sendBatchEvents(): String {
        IntStream.range(0, 10).forEach { i -> producer.send("test-topic-batch", "message $i") }
        return "Batch of 10 events sent!"
    }
}
