package com.sunny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAutoConfiguration
public class KafkaApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(KafkaApplication.class, args);

    }
}
