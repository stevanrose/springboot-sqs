package com.stevanrose.springsqs.controllers;

import com.stevanrose.springsqs.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sqs")
public class SqsController {

    private static final Logger logger = LoggerFactory.getLogger(SqsController.class);
    private static final String QUEUE_NAME = "spring_integration_queue";

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @PostMapping(value = "/send")
    @ResponseStatus(HttpStatus.OK)
    public void send(@RequestBody Message message) {
        logger.info("Sending message {} to SQS queue", message);
        queueMessagingTemplate.convertAndSend(QUEUE_NAME, message);
    }

    @SqsListener(QUEUE_NAME)
    private void receive(Message message) {
        logger.info("Received message {} from SQS Queue", message);
    }

}
