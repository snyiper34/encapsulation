package org.skypro.skyshop.search;

public interface Searchable {
    // Метод получения термина поиска
    String getSearchTerm();

    // Метод получения типа контента
    String getContentType();

    // Метод получения имени объекта
    String getName();

    // Default метод для строкового представления
    default String getStringRepresentation() {
        return getName() + " — " + getContentType();
    }
}