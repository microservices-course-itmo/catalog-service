package com.wine.to.up.catalog.service.messaging;

import com.wine.to.up.catalog.service.domain.entities.*;
import com.wine.to.up.catalog.service.repository.*;
import com.wine.to.up.commonlib.messaging.KafkaMessageHandler;
import com.wine.to.up.parser.common.api.schema.ParserApi;
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
    private final ColorRepository colorRepository;
    private final SugarRepository sugarRepository;

    private final String PRODUCER_NOT_PRESENTED = "PRODUCER_BOT_PRESENTED";
    private final String BRAND_NOT_PRESENTED = "BRAND_NOT_PRESENTED";
    private final String COLOR_NOT_PRESENTED = "COLOR_NOT_PRESENTED";
    private final String SUGAR_NOT_PRESENTED = "SUGAR_NOT_PRESENTED";
    private final String GRAPE_NOT_PRESENTED = "GRAPE_NOT_PRESENTED";
    private final String REGION_NOT_PRESENTED = "REGION_NOT_PRESENTED";
    private final String SHOP_NOT_PRESENTED = "SHOP_NOT_PRESENTED";
    private final String COUNTRY_NOT_PRESENTED = "COUNTRY_NOT_PRESENTED";

    @Override
    public void handle(WineParsedEvent wineParsedEvent) {
        log.info("Message received from " + wineParsedEvent.getParserName() + " and site " + wineParsedEvent.getShopLink());
        log.info("Received " + wineParsedEvent.getWinesList().size() + " wines");
        log.info("Wine parsed event: " + wineParsedEvent.toString());

        wineParsedEvent.getWinesList()
                .stream()
                .forEach(parserWine -> {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            synchronized (this){
                                try {
                                    log.info(parserWine.getName() + " received");
                                    WinePosition winePosition = new WinePosition();
                                    winePosition.setId(UUID.randomUUID().toString());
                                    winePositionRepository.save(winePosition);

                                    boolean isWineExists = isWineExists(parserWine.getName());
                                    log.info(isWineExists ? "Wine exists" : "Wine not found");

                                    Wine wine = getWineAssociatedWithWinePosition(parserWine.getName(), winePosition);
                                    if (!isWineExists) {
                                        associateWineWithProducer(wine, parserWine);
                                        associateWineWithBrand(wine, parserWine);
                                        associateWineWithColor(wine, parserWine);
                                        associateWineWithSugar(wine, parserWine);

                                        associateWineWithGrapes(wine, parserWine);
                                        associateWineWithRegions(wine, parserWine);

                                        wine.setProduction_year(parserWine.getYear());
                                        log.info("New wine created with year {}", parserWine.getYear());
                                        wine.setStrength(parserWine.getStrength());
                                        log.info("New wine created with strength {}", parserWine.getStrength());

                                        wineRepository.save(wine);
                                    }

                                    winePosition.setWpWine(wineRepository.findWineByWineID(wine.getWineID()));
                                    winePosition.setDescription(parserWine.getDescription());
                                    winePosition.setImage(parserWine.getImage().getBytes());
                                    winePosition.setVolume(parserWine.getCapacity());
                                    winePosition.setPrice(parserWine.getOldPrice());
                                    winePosition.setActualPrice(parserWine.getNewPrice());
                                    winePosition.setGastronomy(parserWine.getGastronomy());
                                    winePosition.setLinkToWine(parserWine.getLink());

                                    associateWinePositionWithShop(winePosition, wineParsedEvent);

                                    winePositionRepository.save(winePosition);
                                    log.info(parserWine.getName() + " saved");
                                } catch (Exception e) {
                                    log.error(e.getMessage());
                                    log.error(e.toString());
                                    log.error((Arrays.stream(e.getStackTrace()).map(StackTraceElement::toString).reduce((x, y) -> x + "\n" + y).get()));
                                }
                            }
                        }
                    }).start();
                });
    }

    private void associateWineWithProducer(Wine wine, ParserApi.Wine parserWine) {
        boolean isProducerPresented = parserWine.getManufacturer() != null;
        Producer producer;
        if (isProducerPresented) {
            producer = getProducerAssociatedWithWine(parserWine.getManufacturer(), wine);
        } else {
            producer = getProducerAssociatedWithWine(PRODUCER_NOT_PRESENTED, wine);
        }
        wine.setWineProducer(producer);
    }

    private void associateWineWithBrand(Wine wine, ParserApi.Wine parserWine) {
        boolean isBrandPresented = parserWine.getBrand() != null;
        Brand brand;
        if (isBrandPresented) {
            brand = getBrandAssociatedWithWine(parserWine.getBrand(), wine);
        } else {
            brand = getBrandAssociatedWithWine(BRAND_NOT_PRESENTED, wine);
        }
        wine.setWineBrand(brand);
    }

    private void associateWineWithColor(Wine wine, ParserApi.Wine parserWine) {
        boolean isColorPresented = parserWine.getColor() != null;
        Color color;
        if (isColorPresented) {
            color = getColorAssociatedWithWine(parserWine.getColor().name(), wine);
        } else {
            color = getColorAssociatedWithWine(COLOR_NOT_PRESENTED, wine);
        }
        wine.setWineColor(color);
    }

    private void associateWineWithSugar(Wine wine, ParserApi.Wine parserWine) {
        boolean isSugarPresented = parserWine.getSugar() != null;
        Sugar sugar;
        if (isSugarPresented) {
            sugar = getSugarAssociatedWithWine(parserWine.getSugar().name(), wine);
        } else {
            sugar = getSugarAssociatedWithWine(SUGAR_NOT_PRESENTED, wine);
        }
        wine.setWineSugar(sugar);
    }

    private void associateWineWithGrapes(Wine wine, ParserApi.Wine parserWine) {
        boolean isGrapeListPresented = parserWine.getGrapeSortList() != null;
        List<Grape> grapes = new ArrayList<>();
        if (isGrapeListPresented) {
            boolean isGrapeListEmpty = parserWine.getGrapeSortList().isEmpty();
            if (!isGrapeListEmpty) {
                parserWine.getGrapeSortList().forEach(x -> grapes.add(getGrapeAssociatedWithWine(x, wine)));
            }
        } else {
            grapes.add(getGrapeAssociatedWithWine(GRAPE_NOT_PRESENTED, wine));
        }
        wine.setWineGrape(grapes);
    }

    private void associateWineWithRegions(Wine wine, ParserApi.Wine parserWine) {
        boolean isRegionListPresented = parserWine.getRegionList() != null;
        List<Region> regions = new ArrayList<>();
        if (isRegionListPresented) {
            boolean isRegionListEmpty = parserWine.getRegionList().isEmpty();
            if (!isRegionListEmpty) {
                parserWine.getRegionList().forEach(x -> regions.add(getRegionAssociatedWithWine(x, parserWine.getCountry(), wine)));
            }
        } else {
            regions.add(getRegionAssociatedWithWine(REGION_NOT_PRESENTED, COUNTRY_NOT_PRESENTED, wine));
        }
        wine.setWineRegion(regions);
    }

    private void associateWinePositionWithShop(WinePosition winePosition, ParserApi.WineParsedEvent wineParsedEvent) {
        boolean isShopPresented = wineParsedEvent.getShopLink() != null;
        Shop shop;
        if (isShopPresented) {
            shop = getShopAssociatedWithWinePosition(wineParsedEvent.getShopLink(), winePosition);
        } else {
            shop = getShopAssociatedWithWinePosition(SHOP_NOT_PRESENTED, winePosition);
        }
        winePosition.setShop(shop);
    }

    private boolean isWineExists(String wineName) {
        return wineRepository.findByWineName(wineName) != null;
    }

    private Wine createWine(String wineName) {
        Wine wine = new Wine();
        wine.setWineID(UUID.randomUUID().toString());
        wine.setWineName(wineName);
        wine.setWinePositions(new ArrayList<>());
        log.info("Вино с названием {} создан", wineName);
        return wine;
    }

    private Wine getWineAssociatedWithWinePosition(String wineName, WinePosition winePosition) {
        boolean isWineExists = isWineExists(wineName);
        log.info("Вино с названием " + wineName + (isWineExists ? " " : " не ") + "существует");
        Wine byWineName = isWineExists ? wineRepository.findByWineName(wineName) : createWine(wineName);
        byWineName.getWinePositions().add(winePosition);
        wineRepository.save(byWineName);
        return byWineName;
    }

    private boolean isShopExists(String shopSite) {
        return shopRepository.findByShopSite(shopSite) != null;
    }

    private Shop createShop(String shopSite) {
        Shop shop = new Shop();
        shop.setShopSite(shopSite);
        shop.setShopID(UUID.randomUUID().toString());
        shop.setWinePositions(new ArrayList<>());
        log.info("Магазин с ссылкой {} создан", shopSite);
        return shop;
    }

    private Shop getShopAssociatedWithWinePosition(String shopSite, WinePosition winePosition) {
        boolean isShopExists = isShopExists(shopSite);
        log.info("Магазин с ссылкой " + shopSite + (isShopExists ? " " : " не ") + "существует");
        Shop byShopSite = isShopExists ? shopRepository.findByShopSite(shopSite) : createShop(shopSite);
        byShopSite.getWinePositions().add(winePosition);
        shopRepository.save(byShopSite);
        return byShopSite;
    }

    private boolean isBrandExists(String brandName) {
        return brandRepository.findBrandByBrandName(brandName) != null;
    }

    private Brand createBrand(String brandName) {
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setBrandID(UUID.randomUUID().toString());
        brand.setBrandWines(new ArrayList<>());
        log.info("Бренд с названием {} создан", brandName);
        return brand;
    }

    private Brand getBrandAssociatedWithWine(String brandName, Wine wine) {
        boolean isBrandExists = isBrandExists(brandName);
        log.info("Бренд с названием " + brandName + (isBrandExists ? " " : " не ") + "существует");
        Brand byBrandName = isBrandExists ? brandRepository.findBrandByBrandName(brandName) : createBrand(brandName);
        byBrandName.getBrandWines().add(wine);
        brandRepository.save(byBrandName);
        return byBrandName;
    }

    private boolean isGrapeExists(String grapeName) {
        return grapeRepository.findByGrapeName(grapeName) != null;
    }

    private Grape createGrape(String grapeName) {
        Grape grape = new Grape();
        grape.setGrapeName(grapeName);
        grape.setGrapeID(UUID.randomUUID().toString());
        grape.setGrapeWines(new ArrayList<>());
        log.info("Сорт с названием {} создан", grapeName);
        return grape;
    }

    private Grape getGrapeAssociatedWithWine(String grapeName, Wine wine) {
        boolean isGrapeExists = isGrapeExists(grapeName);
        log.info("Сорт с названием " + grapeName + (isGrapeExists ? " " : " не ") + "существует");
        Grape byGrapeName = isGrapeExists ? grapeRepository.findByGrapeName(grapeName) : createGrape(grapeName);
        byGrapeName.getGrapeWines().add(wine);
        grapeRepository.save(byGrapeName);
        return byGrapeName;
    }

    private boolean isProducerExists(String producerName) {
        return producerRepository.findByProducerName(producerName) != null;
    }

    private Producer createProducer(String producerName) {
        Producer producer = new Producer();
        producer.setProducerName(producerName);
        producer.setProducerID(UUID.randomUUID().toString());
        producer.setProducerWines(new ArrayList<>());
        log.info("Производитель с названием {} создан", producerName);
        return producer;
    }

    private Producer getProducerAssociatedWithWine(String producerName, Wine wine) {
        boolean isProducerExists = isProducerExists(producerName);
        log.info("Производитель с названием " + producerName + (isProducerExists ? " " : " не ") + "существует");
        Producer byProducerName = isProducerExists ? producerRepository.findByProducerName(producerName) : createProducer(producerName);
        byProducerName.getProducerWines().add(wine);
        producerRepository.save(byProducerName);
        return byProducerName;
    }

    private boolean isRegionExists(String regionName) {
        return regionRepository.findByRegionName(regionName) != null;
    }

    private Region createRegion(String regionName, String countryName) {
        Region region = new Region();
        region.setRegionName(regionName);
        region.setRegionID(UUID.randomUUID().toString());
        region.setRegionCountry(countryName);
        region.setRegionWines(new ArrayList<>());
        log.info("Регион с названием {} создан", regionName);
        return region;
    }

    private Region getRegionAssociatedWithWine(String regionName, String countryName, Wine wine) {
        boolean isRegionExists = isRegionExists(regionName);
        log.info("Регион с названием " + regionName + (isRegionExists ? " " : " не ") + "существует");
        Region byRegionName = isRegionExists ? regionRepository.findByRegionName(regionName) : createRegion(regionName, countryName);
        byRegionName.getRegionWines().add(wine);
        regionRepository.save(byRegionName);
        return byRegionName;
    }

    private boolean isColorExists(String colorName) {
        return colorRepository.findByColorName(colorName) != null;
    }

    private Color createColor(String colorName) {
        Color color = new Color();
        color.setColorName(colorName);
        color.setColorID(UUID.randomUUID().toString());
        color.setColorWines(new ArrayList<>());
        log.info("Цвет с названием {} создан", colorName);
        return color;
    }

    private Color getColorAssociatedWithWine(String colorName, Wine wine) {
        boolean isColorExists = isColorExists(colorName);
        log.info("Цвета с названием " + colorName + (isColorExists ? " " : " не ") + "существует");
        Color byColorName = isColorExists ? colorRepository.findByColorName(colorName) : createColor(colorName);
        byColorName.getColorWines().add(wine);
        colorRepository.save(byColorName);
        return byColorName;
    }

    private boolean isSugarExists(String sugarName) {
        return sugarRepository.findBySugarName(sugarName) != null;
    }

    private Sugar createSugar(String sugarName) {
        Sugar sugar = new Sugar();
        sugar.setSugarName(sugarName);
        sugar.setSugarID(UUID.randomUUID().toString());
        sugar.setSugarWines(new ArrayList<>());
        log.info("Сахар с названием {} создан", sugarName);
        return sugar;
    }

    private Sugar getSugarAssociatedWithWine(String sugarName, Wine wine) {
        boolean isSugarExists = isSugarExists(sugarName);
        log.info("Сахар с названием " + sugarName + (isSugarExists ? " " : " не ") + "существует");
        Sugar bySugarName = isSugarExists ? sugarRepository.findBySugarName(sugarName) : createSugar(sugarName);
        bySugarName.getSugarWines().add(wine);
        sugarRepository.save(bySugarName);
        return bySugarName;
    }
}
