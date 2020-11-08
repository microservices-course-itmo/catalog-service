package com.wine.to.up.catalog.service.messaging;

import com.google.protobuf.Descriptors;
import com.wine.to.up.catalog.service.domain.entities.*;
import com.wine.to.up.catalog.service.domain.enums.Color;
import com.wine.to.up.catalog.service.domain.enums.Sugar;
import com.wine.to.up.catalog.service.repository.BrandRepository;
import com.wine.to.up.catalog.service.repository.GrapeRepository;
import com.wine.to.up.catalog.service.repository.ProducerRepository;
import com.wine.to.up.catalog.service.repository.RegionRepository;
import com.wine.to.up.catalog.service.service.WinePositionService;
import com.wine.to.up.commonlib.messaging.KafkaMessageHandler;
import com.wine.to.up.parser.common.api.schema.ParserApi.WineParsedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class ParserTopicKafkaMessageHandler implements KafkaMessageHandler<WineParsedEvent> {

    private WinePositionService winePositionService;
    private BrandRepository brandRepository;
    private GrapeRepository grapeRepository;
    private ProducerRepository producerRepository;
    private RegionRepository regionRepository;


    @Override
    public void handle(WineParsedEvent wineParsedEvent) {
        wineParsedEvent.getWinesList()
                .stream()
                .map(parserWine -> {
                    Wine wine = new Wine();
                    wine.setWineID(UUID.randomUUID().toString());
                    wine.setWineName(parserWine.getName());
                    wine.setProduction_year(parserWine.getYear());
                    wine.setStrength(parserWine.getStrength());

                    Optional<Color> firstColour = Arrays.stream(Color.values()).filter(x -> x.name().toLowerCase()
                            .equals(parserWine.getColor().name().toLowerCase())).findFirst();
                    wine.setWineColor(firstColour.get());

                    Optional<Sugar> firstSugar = Arrays.stream(Sugar.values()).filter(x -> x.name().toLowerCase()
                            .equals(parserWine.getSugar().name().toLowerCase())).findFirst();
                    wine.setWineSugar(firstSugar.get());


                    if (producerRepository.findByProducerName(parserWine.getManufacturer()) == null) {
                        Producer producer = new Producer();
                        producer.setProducerID(UUID.randomUUID().toString());
                        producer.setProducerName(parserWine.getManufacturer());
                        producer.setProducerWines(null);
                        producerRepository.save(producer);
                    }
                    wine.setWineProducer(producerRepository.findByProducerName(parserWine.getManufacturer()));


                    if (brandRepository.findBrandByBrandName(parserWine.getBrand()) == null) {
                        Brand brand = new Brand();
                        brand.setBrandID(UUID.randomUUID().toString());
                        brand.setBrandName(parserWine.getBrand());
                        brand.setBrandWines(List.of(wine));
                        brandRepository.save(brand);
                    }
                    wine.setWineBrand(brandRepository.findBrandByBrandName(parserWine.getBrand()));

                    Descriptors.FieldDescriptor grapeDescriptor = parserWine.getDescriptorForType().findFieldByName("grape_sort");
                    int grapeCount = parserWine.getRepeatedFieldCount(grapeDescriptor);

                    for (int i = 0; i < grapeCount; i++) {
                        if (grapeRepository.findByGrapeName(parserWine.getGrapeSort(i)) == null){
                            Grape grape = new Grape();
                            grape.setGrapeID(UUID.randomUUID().toString());
                            grape.setGrapeName(parserWine.getGrapeSort(i));
                            grape.setGrapeWines(null);
                            grapeRepository.save(grape);
                        }
                    }

                    if (grapeCount > 0){
                        wine.setWineGrape(grapeRepository.findByGrapeName(parserWine.getGrapeSort(0)));
                    }

                    Descriptors.FieldDescriptor regionDescriptor = parserWine.getDescriptorForType().findFieldByName("region");
                    int regionCount = parserWine.getRepeatedFieldCount(regionDescriptor);
                    List<Region> regions = new ArrayList<>();

                    for (int i = 0; i < regionCount; i++) {
                        if (regionRepository.findByRegionName(parserWine.getRegion(i)) == null){
                            Region region = new Region();
                            region.setRegionID(UUID.randomUUID().toString());
                            region.setRegionCountry(parserWine.getCountry());
                            region.setRegionName(parserWine.getRegion(i));
                            regionRepository.save(region);
                        }
                    }
                    if (regionCount > 0){
                        wine.setWineRegion(regionRepository.findByRegionID(parserWine.getRegion(0)));
                    }
                });
    }
}
