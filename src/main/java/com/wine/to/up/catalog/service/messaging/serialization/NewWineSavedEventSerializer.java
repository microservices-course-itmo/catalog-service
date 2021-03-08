package com.wine.to.up.catalog.service.messaging.serialization;

import com.wine.to.up.catalog.service.api.message.NewWineSavedMessageSentEventOuterClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;
public class NewWineSavedEventSerializer implements Serializer<NewWineSavedMessageSentEventOuterClass.NewWineSavedMessageSentEvent> {
    @Override
    public byte[] serialize(String topic, NewWineSavedMessageSentEventOuterClass.NewWineSavedMessageSentEvent newWineSavedMessageSentEvent) {
        return newWineSavedMessageSentEvent.toByteArray();
    }
}
