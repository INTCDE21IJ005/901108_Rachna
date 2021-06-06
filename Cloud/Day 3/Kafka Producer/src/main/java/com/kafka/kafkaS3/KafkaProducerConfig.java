package com.kafka.kafkaS3;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serdes.StringSerde;
import org.apache.kafka.connect.json.JsonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;

@SuppressWarnings("unused")
public class KafkaProducerConfig {
	
	@Bean
	public ProducerFactory<String,Employee> producerFactory(){
		Map<String,Object> config = new HashMap<String,Object>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<String, Employee>(config);
		
	}
	
	@Bean
	public KafkaTemplate<String,Employee> kafkaTemplate(){
		return new KafkaTemplate<String,Employee>(producerFactory());
	}
}
