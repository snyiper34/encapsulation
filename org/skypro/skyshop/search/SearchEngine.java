package org.skypro.skyshop.search;


import org.skypro.skyshop.Searchable;
import org.skypro.skyshop.search.exceptions.BestResultNotFound;
import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private List<Searchable> items = new ArrayList<>();

    public void addItem(Searchable item) {
        items.add(item);
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (items.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : items) {
            String searchTerm = item.getSearchTerm().toLowerCase();
            String searchLower = search.toLowerCase();

            int count = 0;
            int index = 0;
            while ((index = searchTerm.indexOf(searchLower, index)) != -1) {
                count++;
                index += searchLower.length();
            }

            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        if (maxCount == 0) {
            throw new BestResultNotFound(search);
        }

        return bestMatch;
    }
}