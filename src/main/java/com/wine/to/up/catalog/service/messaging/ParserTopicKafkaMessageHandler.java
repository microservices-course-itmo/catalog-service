package com.wine.to.up.catalog.service.messaging;

import com.wine.to.up.catalog.service.domain.entities.Brand;
import com.wine.to.up.catalog.service.domain.entities.Grape;
import com.wine.to.up.catalog.service.domain.entities.Producer;
import com.wine.to.up.catalog.service.domain.entities.Wine;
import com.wine.to.up.catalog.service.domain.enums.Color;
import com.wine.to.up.catalog.service.repository.BrandRepository;
import com.wine.to.up.catalog.service.repository.GrapeRepository;
import com.wine.to.up.catalog.service.repository.ProducerRepository;
import com.wine.to.up.catalog.service.service.BrandService;
import com.wine.to.up.catalog.service.service.WinePositionService;
import com.wine.to.up.commonlib.messaging.KafkaMessageHandler;
import com.wine.to.up.parser.common.api.schema.ParserApi.WineParsedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class ParserTopicKafkaMessageHandler implements KafkaMessageHandler<WineParsedEvent> {

    private WinePositionService winePositionService;
    private BrandRepository brandRepository;
    private GrapeRepository grapeRepository;
    private ProducerRepository producerRepository;


    @Override
    public void handle(WineParsedEvent wineParsedEvent) {
        wineParsedEvent.getWinesList()
                .stream()
                .map(parserWine -> {
                    Wine wine = new Wine();
                    wine.setProduction_year(parserWine.getYear());
                    wine.setStrength(parserWine.getStrength());

                    List<Brand> brandByBrandName = brandRepository.findBrandByBrandName(parserWine.getBrand());
                    wine.setWineBrand(brandByBrandName.get(0));

                    Optional<Color> first = Arrays.stream(Color.values()).filter(x -> x.name().toLowerCase().equals(parserWine.getColor().name().toLowerCase())).findFirst();
                    wine.setWineColor(first.get());

                    String s = parserWine.getGrapeSortList().get(0);
                    Grape byGrapeName = grapeRepository.findByGrapeName(s);
                    wine.setWineGrape(byGrapeName);

                    wine.setWineName(parserWine.getName());

                    Producer byProducerName = producerRepository.findByProducerName(parserWine.getManufacturer());
                    wine.setWineProducer(byProducerName);

                   wine.setWineRegion();
                });
    }
}
