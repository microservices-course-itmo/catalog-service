package com.wine.to.up.catalog.service;

import com.wine.to.up.catalog.service.messaging.ParserTopicKafkaMessageHandler;
import com.wine.to.up.parser.common.api.schema.ParserApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.wine.to.up")
@EnableSwagger2
@EnableAsync
@EnableDiscoveryClient
public class ServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ServiceApplication.class, args);

    }

}
