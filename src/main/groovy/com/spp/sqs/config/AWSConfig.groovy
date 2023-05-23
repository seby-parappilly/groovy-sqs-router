package com.spp.sqs.config
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import software.amazon.awssdk.auth.credentials.AwsCredentials
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.sqs.SqsClient

@Configuration
public class AWSConfig {
    @Value('${cloud.aws.region.static}')
    public String region

    @Value('${cloud.aws.credentials.access-key}')
    public String accessKey

    @Value('${cloud.aws.credentials.secret-key}')
    public String secretKey

    @Bean(name='sqsClient')
    def getSQSClient() {

        SqsClient sqsClient = SqsClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(getAwsCredentialProvider())
                .build()
        sqsClient
    }

    public AwsCredentialsProvider getAwsCredentialProvider() {
        new AwsCredentialsProvider() {

            @Override
            public AwsCredentials resolveCredentials() {
                new AwsCredentials() {

                    @Override
                    public String secretAccessKey() {
                        // TODO Auto-generated method stub
                        secretKey
                    }

                    @Override
                    public String accessKeyId() {
                        // TODO Auto-generated method stub
                        accessKey
                    }
                }
            }

        }
    }
}

