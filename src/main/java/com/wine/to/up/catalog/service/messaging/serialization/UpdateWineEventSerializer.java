package com.wine.to.up.catalog.service.messaging.serialization;

import com.wine.to.up.demo.service.api.message.UpdateWineEventOuterClass;
import org.apache.kafka.common.serialization.Serializer;

public class UpdateWineEventSerializer implements Serializer<UpdateWineEventOuterClass.UpdateWineEvent> {
    @Override
    public byte[] serialize(String s, UpdateWineEventOuterClass.UpdateWineEvent updateWineEvent) {
        return updateWineEvent.toByteArray();
    }
}
