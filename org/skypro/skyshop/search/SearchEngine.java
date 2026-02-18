package org.skypro.skyshop.search;

import org.skypro.skyshop.Searchable;
import org.skypro.skyshop.search.exceptions.BestResultNotFound;
import java.util.*;

public class SearchEngine {
    private List<Searchable> items = new LinkedList<>();

    public void addItem(Searchable item) {
        items.add(item);
    }

    public Map<String, Searchable> search(String searchQuery) {
        Map<String, Searchable> resultMap = new TreeMap<>();

        for (Searchable item : items) {
            String searchTerm = item.getSearchTerm().toLowerCase();
            String searchLower = searchQuery.toLowerCase();

            if (searchTerm.contains(searchLower)) {
                resultMap.put(item.getName(), item);
            }
        }

        return resultMap;
    }

    public void printSearchResults(String searchQuery) {
        Map<String, Searchable> results = search(searchQuery);

        if (results.isEmpty()) {
            System.out.println("Ничего не найдено по запросу: " + searchQuery);
            return;
        }

        System.out.println("Результаты поиска по запросу '" + searchQuery + "':");
        for (Searchable item : results.values()) {
            System.out.println("  - " + item.getStringRepresentation());
        }
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Map<String, Searchable> matches = search(search);

        if (matches.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        return matches.values().iterator().next();
    }
}