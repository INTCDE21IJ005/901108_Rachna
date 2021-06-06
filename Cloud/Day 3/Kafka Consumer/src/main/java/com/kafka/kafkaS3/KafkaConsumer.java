package com.kafka.kafkaS3;

import java.io.ByteArrayInputStream;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaConsumer {
	
	TransferManager mgr = TransferManagerBuilder.defaultTransferManager();
	
	@KafkaListener(topics="first-topic",groupId="group_id")
	public void consumeMessage(String employee) throws JsonProcessingException
	{
		System.out.println(employee);
		ObjectMapper mapper = new ObjectMapper();
		byte[] arr = mapper.writeValueAsBytes(employee);
		ObjectMetadata omd = new ObjectMetadata();
		omd.setContentLength(arr.length);
		mgr.upload("demo-json-bucket","myfile.json",new ByteArrayInputStream(arr),omd);
	}
}
