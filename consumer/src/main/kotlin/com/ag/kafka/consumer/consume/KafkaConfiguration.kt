package com.ag.kafka.consumer.consume

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.config.KafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer


@Configuration
@EnableKafka
class KafkaConfiguration {

    @Value("\${spring.kafka.bootstrapServers}") private lateinit var bootstrapServersConfig: String
    @Value("\${spring.kafka.consumer.group-id}") private lateinit var groupId: String
    @Value("\${spring.kafka.consumer.keyDeserializer}") private lateinit var keyDeserializer: String
    @Value("\${spring.kafka.consumer.valueDeserializer}") private lateinit var valueDeserializer: String
    @Value("\${spring.kafka.consumer.max-poll-records}") private lateinit var maxPollRecords: String
    @Value("\${spring.kafka.consumer.auto-offset-reset}") private lateinit var autoOffsetReset: String

    @Bean
    fun kafkaListenerContainerFactory(): KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Int?, String?>>? {
        val factory = ConcurrentKafkaListenerContainerFactory<Int, String>()
        factory.consumerFactory = consumerFactory()
        factory.setConcurrency(3)
        factory.containerProperties.pollTimeout = 3000
        factory.setBatchListener(true)
        return factory
    }

    @Bean
    fun consumerFactory(): ConsumerFactory<Int, String> {
        return DefaultKafkaConsumerFactory(consumerConfigs())
    }

    @Bean
    fun consumerConfigs(): Map<String, String> {
        val props: HashMap<String, String> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServersConfig
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = keyDeserializer
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = valueDeserializer
        props[ConsumerConfig.MAX_POLL_RECORDS_CONFIG] = maxPollRecords
        props[ConsumerConfig.AUTO_OFFSET_RESET_CONFIG] = autoOffsetReset
        return props;
    }
}
