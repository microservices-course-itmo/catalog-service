package com.wine.to.up.catalog.service.controller;

import com.wine.to.up.catalog.service.domain.request.KafkaWineRequest;
import com.wine.to.up.commonlib.messaging.KafkaMessageSender;
import com.wine.to.up.demo.service.api.message.UpdateWineEventOuterClass;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka")
@Validated
@Slf4j
@Api(value = "Kafka controller", description = "Kafka controller")
public class KafkaController {
    private final KafkaMessageSender<UpdateWineEventOuterClass.UpdateWineEvent> updateWineEventKafkaMessageSender;

    @ApiOperation(value = "Send kafka message",
            nickname = "update", notes = "",
            tags = {"kafka-controller",})
    @PostMapping("/update")
    public void updateWine(@Valid @RequestBody KafkaWineRequest kafkaWineRequest){
        updateWineEventKafkaMessageSender.sendMessage(UpdateWineEventOuterClass.UpdateWineEvent
                .newBuilder()
                .setWineId(kafkaWineRequest.getWineId())
                .setWineName(kafkaWineRequest.getWineName())
                .build());
    }
}
