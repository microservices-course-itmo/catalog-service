package com.wine.to.up.catalog.service.controller;

import com.wine.to.up.catalog.service.api.message.NewWineSavedMessageSentEventOuterClass;
import com.wine.to.up.catalog.service.api.message.UpdatePriceMessageSentEventOuterClass;
import com.wine.to.up.catalog.service.domain.request.KafkaNewWineSaveRequest;
import com.wine.to.up.catalog.service.domain.request.KafkaWineRequest;
import com.wine.to.up.commonlib.messaging.KafkaMessageSender;
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
    private final KafkaMessageSender<UpdatePriceMessageSentEventOuterClass.UpdatePriceMessageSentEvent> updateWineEventKafkaMessageSender;
    private final KafkaMessageSender<NewWineSavedMessageSentEventOuterClass.NewWineSavedMessageSentEvent> newWineSavedMessageSentEventKafkaMessageSender;

    @ApiOperation(value = "Send kafka message",
            nickname = "update", notes = "",
            tags = {"kafka-controller",})
    @PostMapping("/update")
    public void updateWine(@Valid @RequestBody KafkaWineRequest kafkaWineRequest){
        updateWineEventKafkaMessageSender.sendMessage(UpdatePriceMessageSentEventOuterClass.UpdatePriceMessageSentEvent
                .newBuilder()
                .setId(kafkaWineRequest.getWineId())
                .setName(kafkaWineRequest.getWineName())
                .setPrice(kafkaWineRequest.getPrice())
                .build());
    }

    @ApiOperation(value = "Send kafka message",
            nickname = "create", notes = "",
            tags = {"kafka-controller",})
    @PostMapping("/save")
    public void saveNewWine(@Valid @RequestBody KafkaNewWineSaveRequest kafkaNewWineSaveRequest){
        newWineSavedMessageSentEventKafkaMessageSender.sendMessage(NewWineSavedMessageSentEventOuterClass.NewWineSavedMessageSentEvent
                .newBuilder()
                .setWineId(kafkaNewWineSaveRequest.getWineId())
                .setWineName(kafkaNewWineSaveRequest.getWineName())
                .build());
    }
}
