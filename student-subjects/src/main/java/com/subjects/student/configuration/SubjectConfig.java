package com.subjects.student.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.web.client.RestClient;

@Configuration
public class SubjectConfig {
    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl("http://localhost:8781")
                .build();

    }
    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("students-score")
                .partitions(10)
                .replicas(3)
                .compact()
                .build();
    }
}
