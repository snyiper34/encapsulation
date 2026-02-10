package org.skypro.skyshop;

public interface Searchable {
    /**
     * Возвращает поисковый термин для объекта
     */
    String getSearchTerm();

    /**
     * Возвращает тип контента
     */
    String getContentType();

    /**
     * Возвращает имя объекта
     */
    String getName();

    /**
     * Возвращает строковое представление объекта
     */
    String getStringRepresentation();

    /**
     * Default метод для строкового представления (опционально)
     */
    default String getDefaultStringRepresentation() {
        return getName() + " — " + getContentType();
    }
}
