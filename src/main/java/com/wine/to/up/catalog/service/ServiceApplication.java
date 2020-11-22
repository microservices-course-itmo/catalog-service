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
public class ServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ServiceApplication.class, args);
        System.out.println();
        ParserApi.WineParsedEvent defaultInstance = ParserApi.WineParsedEvent.newBuilder()
                .setShopLink("www.www.www")
                .addWines(ParserApi.Wine.newBuilder().build())
                .addWines(ParserApi.Wine.newBuilder().build())
                .addWines(ParserApi.Wine.newBuilder().build())
                .build();
        run.getBean(ParserTopicKafkaMessageHandler.class).handle(defaultInstance);
    }

}
