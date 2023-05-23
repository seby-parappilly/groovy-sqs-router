package com.spp.sqs.config.routes

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component;

@Component
class AmazonSQSReceiverRouter extends RouteBuilder{

    def getSqsQueue(){
        "aws2-sqs://sqs-queue?amazonSQSClient=#sqsClient&defaultVisibilityTimeout=5000&deleteIfFiltered=false&deleteAfterRead=false"
    }

    @Override
    void configure() throws Exception {
        from("aws2-sqs://sqs-queue?amazonSQSClient=#sqsClient&defaultVisibilityTimeout=5000&deleteIfFiltered=false&deleteAfterRead=false")
                .to("log:received-from-sqs");

       /* from("aws2-sqs://sqs-queue?amazonSQSClient=#sqsClient&defaultVisibilityTimeout=5000&deleteIfFiltered=false&deleteAfterRead=false")
                .to("aws2-sqs://sqs-queue2?amazonSQSClient=#sqsClient")
                .to("log:received-from-sqs");

        from("aws2-sqs://sqs-queue2?amazonSQSClient=#sqsClient&defaultVisibilityTimeout=5000&deleteIfFiltered=false&deleteAfterRead=false")
                .to("log:received-from-sqs2");*/

        //from(sqsQueue).to("log:received-from-sqs");

    }
}
