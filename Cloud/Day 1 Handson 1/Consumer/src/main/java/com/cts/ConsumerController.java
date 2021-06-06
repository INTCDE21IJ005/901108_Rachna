package com.cts;

import com.amazonaws.services.sqs.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.naming.java.javaURLContextFactory;
import java.util.*;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
@RestController
public class ConsumerController {
	
	Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

	@GetMapping("/hello")
	public String sayHello() {
		LOGGER.info("START");
		LOGGER.debug("Calling sayHello() with method 'GET'");
		LOGGER.info("END");
		return "Hello..";
	}
	@GetMapping("/readmessages")
	public String getMessage() {
		AmazonSQS sqs = AmazonSQSClientBuilder.standard().build();
		String queueUrl = "https://sqs.us-east-2.amazonaws.com/941516478045/Demo901108";
		ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest().withQueueUrl(queueUrl);
		
		receiveMessageRequest.setMaxNumberOfMessages(10);
		receiveMessageRequest.setWaitTimeSeconds(29);
		String response="";
		while(true) {
			List<Message> messages = sqs.receiveMessage(queueUrl).getMessages();
			if(messages.size()>0)
			{
				for(Message message : messages) {
					response+=message.toString();
					sqs.deleteMessage(queueUrl,message.getReceiptHandle());
				}
			}
			else {
				break;
			}
		}
		return response;
	}
	
}
