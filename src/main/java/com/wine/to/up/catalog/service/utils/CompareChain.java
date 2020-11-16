package com.wine.to.up.catalog.service.utils;

import com.wine.to.up.catalog.service.domain.request.SortByRequest;
import com.wine.to.up.catalog.service.domain.response.WinePositionTrueResponse;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompareChain implements Predicate<WinePositionTrueResponse>, Comparator<WinePositionTrueResponse> {

    private Predicate<WinePositionTrueResponse> chainedPredicate = new Predicate<WinePositionTrueResponse>() {
        @Override
        public boolean test(WinePositionTrueResponse o) {
            return true;
        }
    };
    private Comparator<WinePositionTrueResponse> cmp = new Comparator<WinePositionTrueResponse>() {
        @Override
        public int compare(WinePositionTrueResponse o, WinePositionTrueResponse t1) {
            return 0;
        }
    };

    private static final Map<String, Function<WinePositionTrueResponse, ?>> matrixArguments = new HashMap<String, Function<WinePositionTrueResponse, ?>>() {
        {
            put("shopSite", (WinePositionTrueResponse wptr) -> wptr.getShop().getSite());
            put("producerName", (WinePositionTrueResponse wptr) -> wptr.getWineTrueResponse().getProducerResponse().getName());
            put("brandName", (WinePositionTrueResponse wptr) -> wptr.getWineTrueResponse().getBrandResponse().getName());
            put("regionName", (WinePositionTrueResponse wptr) -> wptr.getWineTrueResponse().getRegionResponse().getName());
            put("countryName", (WinePositionTrueResponse wptr) -> wptr.getWineTrueResponse().getRegionResponse().getCountry());
            put("grapeName", (WinePositionTrueResponse wptr) -> wptr.getWineTrueResponse().getGrapeResponse().getName());

            put("avg", (WinePositionTrueResponse wptr) -> wptr.getWineTrueResponse().getAvg());

            put("color", (WinePositionTrueResponse wptr) -> wptr.getWineTrueResponse().getColor());
            put("sugar", (WinePositionTrueResponse wptr) -> wptr.getWineTrueResponse().getSugar());

            put("year", (WinePositionTrueResponse wptr) -> wptr.getWineTrueResponse().getYear());
            put("price", WinePositionTrueResponse::getPrice);
            put("actual_price", WinePositionTrueResponse::getActual_price);
            put("volume", WinePositionTrueResponse::getVolume);
        }
    };

    public CompareChain process(String searchParameter, List<SortByRequest> sortBy) {
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)([\\s\\S]+?);", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(searchParameter + ";");
        while (matcher.find()) {
            final String value = matcher.group(1);
            final String testValue = matcher.group(3);
            switch (matcher.group(2)) {
                case ":": {
                    chainedPredicate = chainedPredicate.and(new Predicate<WinePositionTrueResponse>() {
                        @Override
                        public boolean test(WinePositionTrueResponse winePositionTrueResponse) {
                            return matrixArguments.get(value).apply(winePositionTrueResponse).equals(testValue);
                        }
                    });
                    break;
                }
                case "<": {
                    chainedPredicate = chainedPredicate.and(new Predicate<WinePositionTrueResponse>() {
                        @Override
                        public boolean test(WinePositionTrueResponse winePositionTrueResponse) {
                            int result = Double.valueOf(matrixArguments.get(value).apply(winePositionTrueResponse).toString()).compareTo(Double.valueOf(testValue));
                            return result < 0;
                        }
                    });
                    break;
                }
                case ">": {
                    chainedPredicate = chainedPredicate.and(new Predicate<WinePositionTrueResponse>() {
                        @Override
                        public boolean test(WinePositionTrueResponse winePositionTrueResponse) {
                            int result = Double.valueOf(matrixArguments.get(value).apply(winePositionTrueResponse).toString()).compareTo(Double.valueOf(testValue));
                            return result > 0;
                        }
                    });
                    break;
                }
            }
        }
        sortBy.forEach(x -> cmp = cmp.thenComparing(new Comparator<WinePositionTrueResponse>() {
            @Override
            public int compare(WinePositionTrueResponse winePositionTrueResponse, WinePositionTrueResponse t1) {
                if(!x.getOrder().equals("ASC")) {
                    return -1 * String.valueOf(matrixArguments.get(x.getAttribute()).apply(winePositionTrueResponse)).compareTo(
                            String.valueOf(matrixArguments.get(x.getAttribute()).apply(t1)));
                } else {
                    return String.valueOf(matrixArguments.get(x.getAttribute()).apply(winePositionTrueResponse)).compareTo(
                            String.valueOf(matrixArguments.get(x.getAttribute()).apply(t1)));
                }
            }
        }));
        return this;
    }

    @Override
    public boolean test(WinePositionTrueResponse winePositionTrueResponse) {
        return chainedPredicate.test(winePositionTrueResponse);
    }

    @Override
    public int compare(WinePositionTrueResponse winePositionTrueResponse, WinePositionTrueResponse t1) {
        return cmp.compare(winePositionTrueResponse, t1);
    }
}
