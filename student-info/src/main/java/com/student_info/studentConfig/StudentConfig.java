package com.student_info.studentConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class StudentConfig
{
    @Bean
    public RestClient restClient()
    {
        return RestClient.builder()
                .baseUrl("http://localhost:8780")
                .build();
    }
}