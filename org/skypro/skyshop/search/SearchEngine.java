package org.skypro.skyshop.search;

import org.skypro.skyshop.Searchable;
import org.skypro.skyshop.search.exceptions.BestResultNotFound;
import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> items;
    private Comparator<Searchable> comparator;

    public SearchEngine() {
        this.items = new HashSet<>();

        this.comparator = (o1, o2) -> {
            int lengthCompare = Integer.compare(o2.getName().length(), o1.getName().length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return o1.getName().compareTo(o2.getName());
        };
    }

    public void addItem(Searchable item) {
        items.add(item);
    }

    public Set<Searchable> search(String searchQuery) {
        return items.stream()
                .filter(item -> item.getSearchTerm().toLowerCase().contains(searchQuery.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Set<Searchable> matches = search(search);

        if (matches.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        return matches.iterator().next();
    }
}