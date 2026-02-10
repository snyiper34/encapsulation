package org.skypro.skyshop.article;

import org.skypro.skyshop.Searchable;

public class Article implements Searchable {
    private String title;
    private String content;

    public Article(String title, String content) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Заголовок статьи не может быть null или пустой строкой. Получено: " + title
            );
        }

        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Содержание статьи не может быть null или пустой строкой"
            );
        }

        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String getSearchTerm() {
        return title + " " + content;
    }

    @Override
    public String getContentType() {
        return "Article";
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String getStringRepresentation() {
        String shortContent = content.length() > 50
                ? content.substring(0, 47) + "..."
                : content;
        return String.format("Статья: %s (%s)", title, shortContent);
    }
}