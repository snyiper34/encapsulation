package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] searchables;
    private int currentIndex;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
        this.currentIndex = 0;
    }

    public void add(Searchable searchable) {
        if (currentIndex < searchables.length) {
            searchables[currentIndex] = searchable;
            currentIndex++;
            System.out.println("Добавлен для поиска: " + searchable.getStringRepresentation());
        } else {
            System.out.println("Невозможно добавить - достигнут лимит элементов поиска");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (Searchable searchable : searchables) {
            if (searchable == null) {
                continue;
            }

            if (searchable.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[resultCount] = searchable;
                resultCount++;

                if (resultCount >= 5) {
                    break;
                }
            }
        }

        System.out.println("По запросу '" + query + "' найдено результатов: " + resultCount);
        return results;
    }

    public void printSearchResults(String query) {
        Searchable[] results = search(query);
        System.out.println("\nРезультаты поиска по запросу: '" + query + "'");

        boolean foundAny = false;
        for (int i = 0; i < results.length; i++) {
            if (results[i] != null) {
                System.out.println((i + 1) + ". " + results[i].getStringRepresentation());
                foundAny = true;
            }
        }

        if (!foundAny) {
            System.out.println("Ничего не найдено");
        }
        System.out.println();
    }
}
