package com.wine.to.up.catalog.service.messaging;

import com.wine.to.up.catalog.service.domain.entities.*;
import com.wine.to.up.catalog.service.domain.enums.Color;
import com.wine.to.up.catalog.service.domain.enums.Sugar;
import com.wine.to.up.catalog.service.repository.*;
import com.wine.to.up.commonlib.messaging.KafkaMessageHandler;
import com.wine.to.up.parser.common.api.schema.ParserApi.WineParsedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ParserTopicKafkaMessageHandler implements KafkaMessageHandler<WineParsedEvent> {

    private final ShopRepository shopRepository;
    private final WineRepository wineRepository;
    private final WinePositionRepository winePositionRepository;
    private final BrandRepository brandRepository;
    private final GrapeRepository grapeRepository;
    private final ProducerRepository producerRepository;
    private final RegionRepository regionRepository;


    @Override
    public void handle(WineParsedEvent wineParsedEvent) {
        log.info("Message received");
        log.info(wineParsedEvent.getParserName());
        log.info(String.valueOf(wineParsedEvent.getWinesList().size()));


        wineParsedEvent.getWinesList()
                .stream()
                .forEach(parserWine -> {
                    try {
                        log.info(parserWine.getName() + " received");
                        int entitiesCreatedCounter = 0;
                        log.info(parserWine.getName() + " start processing");
                        log.info((wineRepository.findByWineName(parserWine.getName()) == null) ? "wine not found" : "wine exists");
                        if (wineRepository.findByWineName(parserWine.getName()) == null) {
                            log.info("Wine not found");
                            Wine wine = new Wine();
                            wine.setWineID(UUID.randomUUID().toString());
                            log.info("New wine created with id {}", wine.getWineID());
                            wine.setWineName(parserWine.getName());
                            log.info("New wine created with name {}", parserWine.getName());
                            wine.setProduction_year(parserWine.getYear());
                            log.info("New wine created with year {}", parserWine.getYear());
                            wine.setStrength(parserWine.getStrength());
                            log.info("New wine created with strength {}", parserWine.getStrength());

                            log.info(parserWine.getColor().name());
                            Optional<Color> firstColour = Arrays.stream(Color.values()).filter(x -> x.name().toLowerCase()
                                    .equals(parserWine.getColor().name().toLowerCase())).findFirst();
                            wine.setWineColor(firstColour.orElse(Color.RED));

                            log.info(parserWine.getSugar().name());
                            Optional<Sugar> firstSugar = Arrays.stream(Sugar.values()).filter(x -> x.name().toLowerCase()
                                    .equals(parserWine.getSugar().name().toLowerCase())).findFirst();
                            wine.setWineSugar(firstSugar.orElse(Sugar.DRY));

                            if (producerRepository.findByProducerName(parserWine.getManufacturer()) == null) {
                                Producer producer = new Producer();
                                producer.setProducerID(UUID.randomUUID().toString());
                                producer.setProducerName(parserWine.getManufacturer());
                                producer.setProducerWines(null);
                                producerRepository.save(producer);
                                entitiesCreatedCounter++;
                            }
                            wine.setWineProducer(producerRepository.findByProducerName(parserWine.getManufacturer()));

                            if (brandRepository.findBrandByBrandName(parserWine.getBrand()) == null) {
                                Brand brand = new Brand();
                                brand.setBrandID(UUID.randomUUID().toString());
                                brand.setBrandName(parserWine.getBrand());
                                brand.setBrandWines(null);
                                brandRepository.save(brand);
                                entitiesCreatedCounter++;
                            }
                            wine.setWineBrand(brandRepository.findBrandByBrandName(parserWine.getBrand()));

                            int grapeCount = parserWine.getGrapeSortCount();

                            for (int i = 0; i < grapeCount; i++) {
                                if (grapeRepository.findByGrapeName(parserWine.getGrapeSort(i)) == null) {
                                    Grape grape = new Grape();
                                    grape.setGrapeID(UUID.randomUUID().toString());
                                    grape.setGrapeName(parserWine.getGrapeSort(i));
                                    grape.setGrapeWines(null);
                                    grapeRepository.save(grape);
                                    entitiesCreatedCounter++;
                                }
                            }

                            if (grapeCount > 0) {
                                wine.setWineGrape(parserWine.getGrapeSortList().stream().map(x -> grapeRepository.findByGrapeID(x)).collect(Collectors.toList()));
                            }

                            int regionCount = parserWine.getRegionCount();

                            for (int i = 0; i < regionCount; i++) {
                                if (regionRepository.findByRegionName(parserWine.getRegion(i)) == null) {
                                    Region region = new Region();
                                    region.setRegionID(UUID.randomUUID().toString());
                                    region.setRegionCountry(parserWine.getCountry());
                                    region.setRegionName(parserWine.getRegion(i));
                                    region.setRegionWines(null);
                                    regionRepository.save(region);
                                    entitiesCreatedCounter++;
                                }
                            }

                            if (regionCount > 0) {
                                wine.setWineRegion(parserWine.getRegionList().stream().map(x -> regionRepository.findByRegionID(x)).collect(Collectors.toList()));
                            }

                            wineRepository.save(wine);
                            entitiesCreatedCounter++;

                            Producer byProducerName = producerRepository.findByProducerName(parserWine.getManufacturer());
                            byProducerName.getProducerWines().add(wine);
                            producerRepository.save(byProducerName);

                            Brand brandByBrandName = brandRepository.findBrandByBrandName(parserWine.getBrand());
                            brandByBrandName.getBrandWines().add(wine);
                            brandRepository.save(brandByBrandName);

                            wine.getWineGrape().forEach(x -> {
                                Grape byId = grapeRepository.findByGrapeID(x.getGrapeID());
                                byId.getGrapeWines().add(wine);
                                grapeRepository.save(byId);
                            });
                            wine.getWineRegion().forEach(x -> {
                                Region byRegionID = regionRepository.findByRegionID(x.getRegionID());
                                byRegionID.getRegionWines().add(wine);
                                regionRepository.save(byRegionID);
                            });
                        }
                        Wine wine = wineRepository.findByWineName(parserWine.getName());


                        if (shopRepository.findByShopSite(wineParsedEvent.getShopLink()) == null) {
                            Shop shop = new Shop();
                            shop.setShopID(UUID.randomUUID().toString());
                            shop.setShopSite(wineParsedEvent.getShopLink());
                            shop.setWinePositions(null);
                            shopRepository.save(shop);
                            entitiesCreatedCounter++;
                        }

                        WinePosition winePosition = new WinePosition();
                        winePosition.setWpWine(wineRepository.findWineByWineID(wine.getWineID()));
                        winePosition.setId(UUID.randomUUID().toString());
                        winePosition.setDescription(parserWine.getDescription());
                        winePosition.setShop(shopRepository.findByShopSite(parserWine.getLink()));
                        winePosition.setImage(parserWine.getImage().getBytes());
                        winePosition.setVolume(parserWine.getCapacity());
                        winePosition.setPrice(parserWine.getOldPrice());
                        winePosition.setActualPrice(parserWine.getNewPrice());
                        winePosition.setGastronomy(parserWine.getGastronomy());

                        winePositionRepository.save(winePosition);

                        Shop byShopSite = shopRepository.findByShopSite(wineParsedEvent.getShopLink());
                        byShopSite.getWinePositions().add(winePosition);
                        shopRepository.save(byShopSite);

                        log.info(parserWine.getName() + " saved");
                        entitiesCreatedCounter++;

                    } catch (Exception e) {
                        log.error(e.getMessage());
                        log.error(e.toString());
                        log.error(e.getCause().getMessage());
                        log.error(e.getLocalizedMessage());
                        log.error(e.getClass().getName());
                    }
                });


    }
}
