package com.cts.dynamaDb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDbConfig {
	@Bean
	public DynamoDBMapper mapper() {
		return new DynamoDBMapper(amazonDynamoDBConfig());
	}

	private AmazonDynamoDB amazonDynamoDBConfig() {
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder
						.EndpointConfiguration("dynamodb.us-east-2.amazon.com", "us-east-2"))
				.withCredentials(new AWSStaticCredentialsProvider
						(new BasicAWSCredentials("AKIA5WNWBKZO4GAMH6G7","WfrITxxAUix/ETEQRjF8oh91ILSJ5bEghZpj6Ob4"))).build();
	}

}
