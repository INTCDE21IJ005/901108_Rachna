package com.cts;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.amazonaws.services.sqs.model.SendMessageRequest;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
@RestController
public class ProducerController
{

	@PostMapping("/sendmessage")
	public String sendMessage(@RequestBody String message) {
		AmazonSQS sqs = AmazonSQSClientBuilder.standard().build();
		String queueUrl = "https://sqs.us-east-2.amazonaws.com/941516478045/Demo901108";
		Map<String,MessageAttributeValue> messageAttributes = new HashMap<String,MessageAttributeValue>();
		messageAttributes.put("Name", new MessageAttributeValue().withStringValue("Cognizant").withDataType("String"));
		SendMessageRequest sendMessage =  new SendMessageRequest().withQueueUrl(queueUrl)
				.withMessageBody(message).withMessageAttributes(messageAttributes).withDelaySeconds(0);
		SendMessageResult result = sqs.sendMessage(sendMessage);
		System.out.println(result.getMessageId());
		return "Message Sent";
	}


	
}

