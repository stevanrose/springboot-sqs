package com.stevanrose.springsqs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSqsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSqsApplication.class, args);
	}

//	@Bean
//	public QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync amazonSqs, ResourceIdResolver resourceIdResolver) {
//		return new QueueMessagingTemplate(amazonSqs, resourceIdResolver);
//	}
}
