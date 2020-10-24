package com.wine.to.up.catalog.service.service;

import com.google.common.primitives.Bytes;
import com.wine.to.up.catalog.service.domain.dto.WinePositionDTO;
import com.wine.to.up.catalog.service.domain.entities.WinePosition;
import com.wine.to.up.catalog.service.domain.request.SettingsRequest;
import com.wine.to.up.catalog.service.domain.request.SortByRequest;
import com.wine.to.up.catalog.service.domain.specifications.WinePositionSpecificationBuilder;
import com.wine.to.up.catalog.service.repository.ShopRepository;
import com.wine.to.up.catalog.service.repository.WinePositionRepository;
import com.wine.to.up.catalog.service.repository.WineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class WinePositionService implements BaseCrudService<WinePositionDTO> {

    private final WinePositionRepository winePositionRepository;
    private final WineRepository wineRepository;
    private final ShopRepository shopRepository;


    public List<WinePositionDTO> readAllWithSettings(SettingsRequest settingsRequest) {
        Sort sort = null;
        for (SortByRequest sortByRequest : settingsRequest.getSortBy()) {
            if (sort == null) {
                sort = sortByRequest.getOrder().equals("desc") ? Sort.by(sortByRequest.getAttribute()).descending() : Sort.by(sortByRequest.getAttribute()).ascending();
            } else {
                sort.and(sortByRequest.getOrder().equals("desc") ? Sort.by(sortByRequest.getAttribute()).descending() : Sort.by(sortByRequest.getAttribute()).ascending());
            }
        }

        PageRequest of = PageRequest.of(settingsRequest.getFrom(), settingsRequest.getTo(), sort);
        return StreamSupport
                .stream(winePositionRepository.findAll(of).spliterator(), false)
                .map(new Function<WinePosition, WinePositionDTO>() {
                    @Override
                    public WinePositionDTO apply(WinePosition winePosition) {
                        return getWinePositionDTO(winePosition);
                    }
                })
                .collect(Collectors.toList());
    }

    public List<WinePositionDTO> readAllWinePositionsWithParameters(String searchParameters){

        WinePositionSpecificationBuilder wpSpecBuilder = new WinePositionSpecificationBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?);", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(searchParameters + ";");

        while (matcher.find()){
            wpSpecBuilder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }

        Specification<WinePosition> wpSpecification = wpSpecBuilder.build();
        List<WinePosition> winePositions = winePositionRepository.findAll(wpSpecification);

        return winePositions.stream().map(this::getWinePositionDTO).collect(Collectors.toList());
    }

    private WinePositionDTO getWinePositionDTO(WinePosition winePosition) {
        WinePositionDTO winePositionDTO = new WinePositionDTO();
        winePositionDTO.setWine_position_id(winePosition.getId());
        winePositionDTO.setWine_id(winePosition.getWpWine().getWineID());
        winePositionDTO.setShop_id(winePosition.getShop().getShopID());
        winePositionDTO.setPrice(winePosition.getPrice());
        winePositionDTO.setActual_price(winePosition.getActual_price());
        winePositionDTO.setLink_to_wine(winePosition.getLinkToWine());
        winePositionDTO.setVolume(winePosition.getVolume());
        winePositionDTO.setDescription(winePosition.getDescription());
        winePositionDTO.setGastronomy(winePosition.getGastronomy());
        winePositionDTO.setImage(Bytes.asList(winePosition.getImage()));
        return winePositionDTO;
    }

    @Override
    public List<WinePositionDTO> readAll() {
        return StreamSupport
                .stream(winePositionRepository.findAll().spliterator(), false)
                .map(new Function<WinePosition, WinePositionDTO>() {
                    @Override
                    public WinePositionDTO apply(WinePosition winePosition) {
                        return getWinePositionDTO(winePosition);
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public void create(WinePositionDTO winePositionDTO) {
        WinePosition winePosition = new WinePosition();
        winePosition.setId(UUID.randomUUID().toString());
        winePosition.setWpWine(wineRepository.findWineByWineID(winePositionDTO.getWine_id()));
        winePosition.setShop(shopRepository.findByShopID(winePositionDTO.getShop_id()));
        winePosition.setPrice(winePositionDTO.getPrice());
        winePosition.setActual_price(winePositionDTO.getActual_price());
        winePosition.setLinkToWine(winePositionDTO.getLink_to_wine());
        winePosition.setVolume(winePositionDTO.getVolume());
        winePosition.setDescription(winePositionDTO.getDescription());
        winePosition.setGastronomy(winePositionDTO.getGastronomy());
        winePosition.setImage(Bytes.toArray(winePositionDTO.getImage()));
        winePositionRepository.save(winePosition);
    }

    @Override
    public WinePositionDTO read(String id) {
        WinePosition byId = winePositionRepository.findById(id).get();
        WinePositionDTO winePositionDTO = new WinePositionDTO();
        winePositionDTO.setWine_position_id(id);
        winePositionDTO.setWine_id(byId.getWpWine().getWineID());
        winePositionDTO.setShop_id(byId.getShop().getShopID());
        winePositionDTO.setPrice(byId.getPrice());
        winePositionDTO.setActual_price(byId.getActual_price());
        winePositionDTO.setLink_to_wine(byId.getLinkToWine());
        winePositionDTO.setVolume(byId.getVolume());
        winePositionDTO.setDescription(byId.getDescription());
        winePositionDTO.setGastronomy(byId.getGastronomy());
        winePositionDTO.setImage(Bytes.asList(byId.getImage()));
        return winePositionDTO;
    }

    @Override
    public void update(String id, WinePositionDTO winePositionDTO) {
        WinePosition winePosition = new WinePosition();
        winePosition.setId(id);
        winePosition.setWpWine(wineRepository.findWineByWineID(winePositionDTO.getWine_id()));
        winePosition.setShop(shopRepository.findByShopID(winePositionDTO.getShop_id()));
        winePosition.setPrice(winePositionDTO.getPrice());
        winePosition.setActual_price(winePositionDTO.getActual_price());
        winePosition.setLinkToWine(winePositionDTO.getLink_to_wine());
        winePosition.setVolume(winePositionDTO.getVolume());
        winePosition.setDescription(winePositionDTO.getDescription());
        winePosition.setGastronomy(winePositionDTO.getGastronomy());
        winePosition.setImage(Bytes.toArray(winePositionDTO.getImage()));
        winePositionRepository.save(winePosition);
    }

    @Override
    public void delete(String id) {
        winePositionRepository.deleteById(id);
    }
}
