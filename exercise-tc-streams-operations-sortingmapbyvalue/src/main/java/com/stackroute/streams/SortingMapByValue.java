package com.stackroute.streams;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
/*
 * SortingMapByValue is a class that has a single method to sort values in the map
 * in any given order and return the values in the
 * map.It uses linked hash map to preserve the order.
 * If the order is not mentioned then an error map is returned
 * */

public class SortingMapByValue {

    Map<String, String> errorMap;
    Map<String, Integer> sortedByValue;

    /*Method to sort the values in the map and return the map based on the order specified */
    public Map sortByValue(Map mapItems, String order) {
        Map<String, Integer> itemPriceMap = mapItems;
        errorMap = new HashMap();

        if (mapItems != null && mapItems.size() > 0) {

            if (order != null && order.equalsIgnoreCase("Descending")) {
                sortedByValue = itemPriceMap.entrySet()
                        .stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


            } else if (order != null && order.equalsIgnoreCase("Ascending")) {

                sortedByValue = itemPriceMap.entrySet()
                        .stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue())
                        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
            } else if (order != null && order.equalsIgnoreCase("Any")) {

                sortedByValue = itemPriceMap.entrySet().stream()
                        .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
            } else {
                errorMap.put("error", "Please provide valid input");
                return errorMap;
            }
        } else {
            errorMap.put("error", "Please provide valid input");
            return errorMap;
        }
        return sortedByValue;
    }


}
