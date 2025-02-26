package com.assignment.assignment.config;

import com.assignment.assignment.mapper.PostMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean  // Manually defining PostMapper as a Spring bean
    public PostMapper postMapper() {
        return new PostMapper();
    }
}
