package org.skypro.skyshop.search;

import org.skypro.skyshop.Searchable;
import org.skypro.skyshop.search.exceptions.BestResultNotFound;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> items = new LinkedList<>();

    public void addItem(Searchable item) {
        items.add(item);
    }

    public List<Searchable> search(String searchQuery) {
        List<Searchable> matches = new LinkedList<>();

        for (Searchable item : items) {
            String searchTerm = item.getSearchTerm().toLowerCase();
            String searchLower = searchQuery.toLowerCase();

            if (searchTerm.contains(searchLower)) {
                matches.add(item);
            }
        }

        return matches;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        List<Searchable> matches = search(search);

        if (matches.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        return matches.get(0);
    }
}