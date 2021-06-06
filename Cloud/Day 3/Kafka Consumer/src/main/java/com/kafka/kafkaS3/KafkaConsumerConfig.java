package com.kafka.kafkaS3;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.*;

import com.kafka.kafkaS3.Employee;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
	
	@Bean
	public ConsumerFactory<String,Employee> consumerFactory(){
		Map<String,Object> config = new HashMap<String,Object>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaConsumerFactory<String, Employee>(config);
		
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,Employee> kafkaTemplatee(){
		ConcurrentKafkaListenerContainerFactory<String,Employee> Factory=new ConcurrentKafkaListenerContainerFactory<String,Employee>();
		 Factory.setConsumerFactory(consumerFactory());
		 return Factory;
	}

}
